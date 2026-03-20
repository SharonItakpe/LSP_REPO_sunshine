package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for holiday customers.
 * Author: Sharon
 */
public class HolidayDiscount implements DiscountStrategy {

    /**
     * Applies a 15 percent discount for a holiday customer.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}