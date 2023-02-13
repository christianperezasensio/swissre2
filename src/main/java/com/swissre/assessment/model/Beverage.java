package com.swissre.assessment.model;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Beverage {

    SMALL_COFFEE("small coffee", new BigDecimal("2.50")),
    MEDIUM_COFFEE("medium coffee", new BigDecimal("3.00")),
    LARGE_COFFEE("large coffee", new BigDecimal("3.50")),
    ORANGE_JUICE("orange juice", new BigDecimal("3.95"));

    private final String description;
    private final BigDecimal price;

    Beverage(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static Beverage fromString(String text) {
        return Arrays.stream(Beverage.values()).filter(beverage -> beverage.description.equalsIgnoreCase(text)).findFirst().orElse(null);
    }
}
