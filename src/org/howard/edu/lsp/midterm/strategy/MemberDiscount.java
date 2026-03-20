package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for member customers.
 * Author: Sharon
 */
public class MemberDiscount implements DiscountStrategy {

    /**
     * Applies a 10 percent discount for a member customer.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}