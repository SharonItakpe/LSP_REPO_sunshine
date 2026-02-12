/**
 * Name: Sharon Itakpe
 */
package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    public static void main(String[] args) {
        int rowsRead = 0;         // non-header lines encountered (including bad ones)
        int rowsTransformed = 0;  // written to output
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

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String productIdStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                int productId;
                BigDecimal price;
                try {
                    productId = Integer.parseInt(productIdStr);
                    price = new BigDecimal(priceStr);
                } catch (Exception e) {
                    rowsSkipped++;
                    continue;
                }

                String originalCategory = category;

                name = name.toUpperCase();

                if (originalCategory.equals("Electronics")) {
                    price = price.multiply(new BigDecimal("0.90"));
                }

                price = price.setScale(2, RoundingMode.HALF_UP);

                if (originalCategory.equals("Electronics")
                        && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                }

                String priceRange = computePriceRange(price);

                bw.write(productId + "," + name + "," + formatTwoDecimals(price) + "," + category + "," + priceRange);
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

    private static String computePriceRange(BigDecimal finalRoundedPrice) {
        BigDecimal ten = new BigDecimal("10.00");
        BigDecimal hundred = new BigDecimal("100.00");
        BigDecimal fiveHundred = new BigDecimal("500.00");

        if (finalRoundedPrice.compareTo(ten) <= 0) {
            return "Low";
        }
        if (finalRoundedPrice.compareTo(ten) > 0 && finalRoundedPrice.compareTo(hundred) <= 0) {
            return "Medium";
        }
        if (finalRoundedPrice.compareTo(hundred) > 0 && finalRoundedPrice.compareTo(fiveHundred) <= 0) {
            return "High";
        }
        return "Premium";
    }

    private static String formatTwoDecimals(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    private static void printSummary(int rowsRead, int rowsTransformed, int rowsSkipped, String outputPath) {
        System.out.println("Run Summary");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}
