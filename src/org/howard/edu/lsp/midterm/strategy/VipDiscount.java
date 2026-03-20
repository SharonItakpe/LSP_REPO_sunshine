package org.howard.edu.lsp.midterm.strategy;

/**
 * Pricing strategy for VIP customers.
 * Author: Sharon
 */
public class VipDiscount implements DiscountStrategy {

    /**
     * Applies a 20 percent discount for a VIP customer.
     *
     * @param price the original purchase price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}
