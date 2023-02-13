package com.swissre.assessment.model;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Beverage {

    SMALL_COFFEE("small coffee", new BigDecimal("2.50"), false),
    MEDIUM_COFFEE("medium coffee", new BigDecimal("3.00"), false),
    LARGE_COFFEE("large coffee", new BigDecimal("3.50"), false),
    ORANGE_JUICE("orange juice", new BigDecimal("3.95"), false);

    private final String description;
    private final BigDecimal price;
    private boolean discount;

    Beverage(String description, BigDecimal price, boolean discount) {
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public static Beverage fromString(String text) {
        return Arrays.stream(Beverage.values()).filter(beverage -> beverage.description.equalsIgnoreCase(text)).findFirst().orElse(null);
    }
}
