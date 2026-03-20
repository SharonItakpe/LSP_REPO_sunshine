package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines a pricing strategy for calculating a final price.
 * Author: Sharon
 */
public interface DiscountStrategy {

    /**
     * Calculates the final price after applying the strategy.
     *
     * @param price the original purchase price
     * @return the final price after applying the strategy
     */
    double calculatePrice(double price);
}