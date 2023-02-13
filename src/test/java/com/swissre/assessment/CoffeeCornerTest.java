package com.swissre.assessment;

import com.swissre.assessment.model.Items;
import org.junit.jupiter.api.Test;

import static com.swissre.assessment.CoffeeCorner.*;
import static com.swissre.assessment.util.Utils.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoffeeCornerTest {

    @Test
    void calculateCasualReceipt() {
        Items items = parseInput(new String[]{readFile("/casual-input.txt")});
        applyDiscounts(items);
        String result = calculateReceipt(items);
        assertEquals(readFile("/casual-output.txt"), result);
    }

    @Test
    void calculateReceiptWithFreeBeverage() {
        Items items = parseInput(new String[]{readFile("/stamp-discount-input.txt")});
        applyDiscounts(items);
        String result = calculateReceipt(items);
        assertEquals(readFile("/stamp-discount-output.txt"), result);
    }

    @Test
    void calculateReceiptWithFreeExtra() {
        Items items = parseInput(new String[]{readFile("/snack-discount-input.txt")});
        applyDiscounts(items);
        String result = calculateReceipt(items);
        assertEquals(readFile("/snack-discount-output.txt"), result);
    }

    @Test
    void calculateReceiptWithFreeExtras() {
        Items items = parseInput(new String[]{readFile("/snack-discounts-input.txt")});
        applyDiscounts(items);
        String result = calculateReceipt(items);
        assertEquals(readFile("/snack-discounts-output.txt"), result);
    }

    @Test
    void calculateReceiptWithFreeExtrasAndBeverages() {
        Items items = parseInput(new String[]{readFile("/multiple-discounts-input.txt")});
        applyDiscounts(items);
        String result = calculateReceipt(items);
        assertEquals(readFile("/multiple-discounts-output.txt"), result);
    }
}
