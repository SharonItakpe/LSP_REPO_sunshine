package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Adds PriceRange based on the final rounded price.
 */
public class PriceRangeTransformer implements Transformer {
    @Override
    public void apply(Product product, TransformContext context) {
        BigDecimal price = product.getPrice();
        BigDecimal ten = new BigDecimal("10.00");
        BigDecimal hundred = new BigDecimal("100.00");
        BigDecimal fiveHundred = new BigDecimal("500.00");

        String range;
        if (price.compareTo(ten) <= 0) {
            range = "Low";
        } else if (price.compareTo(hundred) <= 0) {
            range = "Medium";
        } else if (price.compareTo(fiveHundred) <= 0) {
            range = "High";
        } else {
            range = "Premium";
        }

        product.setPriceRange(range);
    }
}