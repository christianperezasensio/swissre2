package com.swissre.assessment.model;

import java.math.BigDecimal;

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

    private String getDescription() {
        return description;
    }

    private BigDecimal getPrice() {
        return price;
    }
}
