package com.swissre.assessment.model;

import java.math.BigDecimal;

public enum Extra {

    MILK("extra milk", new BigDecimal("0.30")),
    FOAMED_MILK("foamed milk", new BigDecimal("0.50")),
    SPECIAL_ROAST_COFFEE("special roast", new BigDecimal("0.90"));

    private final String description;
    private final BigDecimal price;

    Extra(String description, BigDecimal price) {
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
