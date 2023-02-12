package com.swissre.assessment.model;

import java.math.BigDecimal;

public enum Snack {

    BACON_ROLL("bacon roll", new BigDecimal("4.50"));

    private final String description;
    private final BigDecimal price;

    Snack(String description, BigDecimal price) {
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
