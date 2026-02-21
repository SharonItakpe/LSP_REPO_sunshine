package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a single product row processed by the ETL pipeline.
 * Encapsulates fields and provides safe formatting for output.
 */
public class Product {
    private final int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    /**
     * Creates a Product.
     * @param productId product id
     * @param name product name
     * @param price product price
     * @param category product category
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = "";
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Rounds the current price to 2 decimals using round half up.
     */
    public void roundPriceToTwoDecimalsHalfUp() {
        this.price = this.price.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Formats the price with exactly 2 decimals.
     * @return price as a 2 decimal string
     */
    public String priceTwoDecimals() {
        return this.price.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}