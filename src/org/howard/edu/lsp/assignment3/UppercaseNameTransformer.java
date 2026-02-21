package org.howard.edu.lsp.assignment3;

/**
 * Converts product names to uppercase.
 */
public class UppercaseNameTransformer implements Transformer {
    @Override
    public void apply(Product product, TransformContext context) {
        product.setName(product.getName().toUpperCase());
    }
}