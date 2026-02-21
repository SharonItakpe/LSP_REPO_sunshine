package org.howard.edu.lsp.assignment3;

/**
 * Holds transformation context for a single row, including original values needed
 * by later transformations.
 */
public class TransformContext {
    private final String originalCategory;

    /**
     * Creates a context for a row.
     * @param originalCategory category from the input file before any modifications
     */
    public TransformContext(String originalCategory) {
        this.originalCategory = originalCategory;
    }

    public String getOriginalCategory() {
        return originalCategory;
    }
}