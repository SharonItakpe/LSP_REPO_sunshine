package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * If final rounded price is strictly greater than 500.00 and original category was Electronics,
 * changes category to Premium Electronics.
 */
public class PremiumElectronicsTransformer implements Transformer {
    @Override
    public void apply(Product product, TransformContext context) {
        if (!"Electronics".equals(context.getOriginalCategory())) {
            return;
        }

        BigDecimal threshold = new BigDecimal("500.00");
        if (product.getPrice().compareTo(threshold) > 0) {
            product.setCategory("Premium Electronics");
        }
    }
}