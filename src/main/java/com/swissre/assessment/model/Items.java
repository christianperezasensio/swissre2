package com.swissre.assessment.model;

import java.util.List;

public class Items {

    private final List<Beverage> beverages;
    private final List<Extra> extras;
    private final List<Snack> snacks;
    private int stamps;
    private int beverageDiscounts;
    private int extrasDiscounts;

    public Items(List<Beverage> beverages, List<Extra> extras, List<Snack> snacks) {
        this.beverages = beverages;
        this.extras = extras;
        this.snacks = snacks;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public int getStamps() {
        return stamps;
    }

    public void setStamps(int stamps) {
        this.stamps = stamps;
    }

    public int getBeverageDiscounts() {
        return beverageDiscounts;
    }

    public void setBeverageDiscounts(int beverageDiscounts) {
        this.beverageDiscounts = beverageDiscounts;
    }

    public int getExtrasDiscounts() {
        return extrasDiscounts;
    }

    public void setExtrasDiscounts(int extrasDiscounts) {
        this.extrasDiscounts = extrasDiscounts;
    }
}
