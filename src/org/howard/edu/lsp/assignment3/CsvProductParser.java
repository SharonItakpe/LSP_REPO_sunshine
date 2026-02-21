package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Parses CSV lines into Product objects using Assignment requirements.
 */
public class CsvProductParser {

    /**
     * Attempts to parse a CSV line into a Product.
     * Returns null if the row should be skipped.
     * @param line raw CSV line
     * @return Product or null if invalid
     */
    public Product parseOrNull(String line) {
        if (line == null) {
            return null;
        }

        if (line.trim().isEmpty()) {
            return null;
        }

        String[] parts = line.split(",", -1);
        if (parts.length != 4) {
            return null;
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
            return null;
        }

        return new Product(productId, name, price, category);
    }
}