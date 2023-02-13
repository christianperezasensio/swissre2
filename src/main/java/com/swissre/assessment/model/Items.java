package com.swissre.assessment.model;

import java.util.List;

public class Items {

    private final List<Beverage> beverages;
    private final List<Extra> extras;
    private final List<Snack> snacks;
    private int stamps;

    public Items(List<Beverage> beverages, List<Extra> extras, List<Snack> snacks, int stamps) {
        this.beverages = beverages;
        this.extras = extras;
        this.snacks = snacks;
        this.stamps = stamps;
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
}
