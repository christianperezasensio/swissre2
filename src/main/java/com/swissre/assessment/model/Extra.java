package com.swissre.assessment.model;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Extra {

    MILK("extra milk", new BigDecimal("0.30"), false),
    FOAMED_MILK("foamed milk", new BigDecimal("0.50"), false),
    SPECIAL_ROAST_COFFEE("special roast", new BigDecimal("0.90"), false);

    private final String description;
    private final BigDecimal price;
    private boolean discount;

    Extra(String description, BigDecimal price, boolean discount) {
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

    public static Extra fromString(String text) {
        return Arrays.stream(Extra.values()).filter(extra -> extra.description.equalsIgnoreCase(text)).findFirst().orElse(null);
    }
}
