package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * If original category is Electronics, applies a 10 percent discount to price.
 */
public class ElectronicsDiscountTransformer implements Transformer {
    @Override
    public void apply(Product product, TransformContext context) {
        if ("Electronics".equals(context.getOriginalCategory())) {
            BigDecimal discounted = product.getPrice().multiply(new BigDecimal("0.90"));
            product.setPrice(discounted);
        }
    }
}