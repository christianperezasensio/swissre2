package com.swissre.assessment.model;

import java.math.BigDecimal;
import java.util.Arrays;

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

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public static Extra fromString(String text) {
        return Arrays.stream(Extra.values()).filter(extra -> extra.description.equalsIgnoreCase(text)).findFirst().orElse(null);
    }
}
