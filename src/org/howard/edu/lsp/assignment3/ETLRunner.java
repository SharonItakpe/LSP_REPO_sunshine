package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Runs the full ETL pipeline: extract, transform, load, and run summary.
 */
public class ETLRunner {
    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    private final CsvProductParser parser;
    private final List<Transformer> transformers;

    /**
     * Creates an ETLRunner with default parser and the required transformation steps in order.
     */
    public ETLRunner() {
        this.parser = new CsvProductParser();
        this.transformers = buildTransformersInOrder();
    }

    /**
     * Executes the ETL pipeline with Assignment 2 compatible behavior.
     */
    public void run() {
        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File inputFile = new File(INPUT_PATH);
        if (!inputFile.exists()) {
            System.out.println("Error: Missing input file at " + INPUT_PATH);
            System.out.println("Program exiting cleanly.");
            return;
        }

        File outputFile = new File(OUTPUT_PATH);

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = br.readLine();

            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            if (header == null) {
                printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile.getPath());
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;

                Product product = parser.parseOrNull(line);
                if (product == null) {
                    rowsSkipped++;
                    continue;
                }

                TransformContext context = new TransformContext(product.getCategory());

                applyTransformations(product, context);

                bw.write(product.getProductId() + "," +
                        product.getName() + "," +
                        product.priceTwoDecimals() + "," +
                        product.getCategory() + "," +
                        product.getPriceRange());
                bw.newLine();

                rowsTransformed++;
            }

        } catch (IOException e) {
            System.out.println("Error: Problem reading or writing files.");
            System.out.println("Details: " + e.getMessage());
            System.out.println("Program exiting cleanly.");
            return;
        }

        printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile.getPath());
    }

    private void applyTransformations(Product product, TransformContext context) {
        for (Transformer t : transformers) {
            t.apply(product, context);

            if (t instanceof ElectronicsDiscountTransformer) {
                product.roundPriceToTwoDecimalsHalfUp();
            }
            if (t instanceof PremiumElectronicsTransformer) {
                // price already rounded prior to this transformer in the required order
            }
        }
        // Ensure rounded exactly two decimals for final output and price range logic.
        product.roundPriceToTwoDecimalsHalfUp();
    }

    private List<Transformer> buildTransformersInOrder() {
        List<Transformer> list = new ArrayList<>();
        list.add(new UppercaseNameTransformer());          // step 1
        list.add(new ElectronicsDiscountTransformer());     // step 2
        list.add(new PremiumElectronicsTransformer());      // step 3 (uses final rounded price)
        list.add(new PriceRangeTransformer());              // step 4
        return list;
    }

    private void printSummary(int rowsRead, int rowsTransformed, int rowsSkipped, String outputPath) {
        System.out.println("Run Summary");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}