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

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
