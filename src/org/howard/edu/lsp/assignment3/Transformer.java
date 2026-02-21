package org.howard.edu.lsp.assignment3;

/**
 * A single transformation step in the ETL pipeline.
 * Implementations must apply transformations in place to the given Product.
 */
public interface Transformer {
    /**
     * Applies a transformation to a product.
     * @param product product to transform
     * @param context context containing original row info
     */
    void apply(Product product, TransformContext context);
}