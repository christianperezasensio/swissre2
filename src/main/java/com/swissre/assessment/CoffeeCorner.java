package com.swissre.assessment;

import com.swissre.assessment.model.Beverage;
import com.swissre.assessment.model.Extra;
import com.swissre.assessment.model.Items;
import com.swissre.assessment.model.Snack;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static com.swissre.assessment.model.Snack.BACON_ROLL;

public class CoffeeCorner {

    private static final String COMMA_DELIMITER = ", ";
    private static final String LINE_DELIMITER = "\n";
    private static final String EXTRAS_DELIMITER = " with";
    private static final String STAMP_CARD_MATCHER = "stamp card ";

    public static void main(String[] args) {
        Items items;

        //One example in case it is not compiled with javac
        if (args.length == 0) {
            String[] input = {"large coffee with extra milk, small coffee with special roast, bacon roll, orange juice, stamp card 5"};
            items = parseInput(input);
        } else {
            items = parseInput(args);
        }

        applyDiscounts(items);
        String result = calculateReceipt(items);
        System.out.println(result);
    }

    protected static Items parseInput(String[] input) {
        List<Beverage> beverages = new ArrayList<>();
        List<Extra> extras = new ArrayList<>();
        List<Snack> snacks = new ArrayList<>();
        Items items = new Items(beverages, extras, snacks);

        Arrays.stream(input).forEach(s -> {
            String[] itemArray = s.split(COMMA_DELIMITER);
            Arrays.stream(itemArray).forEach(s1 -> {
                if (s1.contains(STAMP_CARD_MATCHER)) {
                    String stamps = s1.substring(STAMP_CARD_MATCHER.length());
                    items.setStamps(Integer.parseInt(stamps));
                } else if (s1.equals("bacon roll")) {
                    snacks.add(BACON_ROLL);
                } else {
                    if (s1.contains(EXTRAS_DELIMITER)) {
                        String[] items1 = s1.split(EXTRAS_DELIMITER);
                        beverages.add(Beverage.fromString(items1[0]));
                        extras.add(Extra.fromString(items1[1].substring(1)));
                    } else {
                        beverages.add(Beverage.fromString(s1));
                    }
                }
            });
        });

        return items;
    }

    protected static void applyDiscounts(Items items) {
        items.getBeverages().sort(Comparator.comparing(Beverage::getPrice).reversed());
        items.getExtras().sort(Comparator.comparing(Extra::getPrice).reversed());
        stampDiscount(items);
        snackDiscount(items);
    }

    private static void stampDiscount(Items items) {
        if (items.getStamps() == 5) {
            items.getBeverages().stream().findFirst().ifPresent(beverage -> items.setBeverageDiscounts(1));
        }
    }

    private static void snackDiscount(Items items) {
        int discountedExtras = items.getSnacks().size();
        if (discountedExtras > 0) {
            IntStream.range(0, discountedExtras).forEach(i -> items.setExtrasDiscounts(items.getExtrasDiscounts() + 1));
        }
    }

    protected static String calculateReceipt(Items items) {
        StringBuilder stringBuilder = new StringBuilder();
        saveHeader(stringBuilder);

        int quantity = 0;
        int freeOfCharge = 0;
        String description = "";
        String newDescription;
        BigDecimal unitPrice = new BigDecimal("0.00");
        BigDecimal total = new BigDecimal("0.00");
        BigDecimal grandTotal = new BigDecimal("0.00");

        for (Beverage beverage : items.getBeverages()) {
            newDescription = beverage.getDescription();

            if (newDescription.equals(description)) {
                quantity++;
                if (items.getBeverageDiscounts() > 0) {
                    freeOfCharge++;
                    items.setBeverageDiscounts(items.getBeverageDiscounts() - 1);
                } else {
                    total = total.add(beverage.getPrice());
                }
            } else {
                if (!description.equals("")) {
                    saveLine(stringBuilder, quantity, freeOfCharge, description, unitPrice, total);
                    grandTotal = grandTotal.add(total);
                }

                quantity = 1;
                description = beverage.getDescription();
                unitPrice = beverage.getPrice();

                if (items.getBeverageDiscounts() > 0) {
                    freeOfCharge = 1;
                    items.setBeverageDiscounts(items.getBeverageDiscounts() - 1);
                    total = new BigDecimal("0.00");
                } else {
                    freeOfCharge = 0;
                    total = beverage.getPrice();
                }
            }
        }

        for (Extra extra : items.getExtras()) {
            newDescription = extra.getDescription();

            if (newDescription.equals(description)) {
                quantity++;
                if (items.getExtrasDiscounts() > 0) {
                    freeOfCharge++;
                    items.setExtrasDiscounts(items.getExtrasDiscounts() - 1);
                } else {
                    total = total.add(extra.getPrice());
                }
            } else {
                saveLine(stringBuilder, quantity, freeOfCharge, description, unitPrice, total);
                grandTotal = grandTotal.add(total);

                quantity = 1;
                description = extra.getDescription();
                unitPrice = extra.getPrice();

                if (items.getExtrasDiscounts() > 0) {
                    freeOfCharge = 1;
                    items.setExtrasDiscounts(items.getExtrasDiscounts() - 1);
                    total = new BigDecimal("0.00");
                } else {
                    freeOfCharge = 0;
                    total = extra.getPrice();
                }
            }
        }

        for (Snack snack : items.getSnacks()) {
            newDescription = snack.getDescription();

            if (newDescription.equals(description)) {
                quantity++;
                total = total.add(snack.getPrice());
            } else {
                saveLine(stringBuilder, quantity, freeOfCharge, description, unitPrice, total);
                grandTotal = grandTotal.add(total);

                quantity = 1;
                description = snack.getDescription();
                unitPrice = snack.getPrice();
                freeOfCharge = 0;
                total = snack.getPrice();
            }
        }

        saveLine(stringBuilder, quantity, freeOfCharge, description, unitPrice, total);
        grandTotal = grandTotal.add(total);
        saveGrandTotal(stringBuilder, grandTotal);

        return stringBuilder.toString();
    }

    private static void saveHeader(StringBuilder stringBuilder) {
        stringBuilder.append("QTY, FOC, Description, Unit Price, Total");
        stringBuilder.append(LINE_DELIMITER);
    }

    private static void saveLine(StringBuilder stringBuilder, int quantity, int freeOfCharge, String description, BigDecimal unitPrice, BigDecimal total) {
        stringBuilder.append(quantity);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(freeOfCharge);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(description);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(unitPrice);
        stringBuilder.append(COMMA_DELIMITER);
        stringBuilder.append(total);
        stringBuilder.append(LINE_DELIMITER);
    }

    private static void saveGrandTotal(StringBuilder stringBuilder, BigDecimal grandTotal) {
        stringBuilder.append("TOTAL ");
        stringBuilder.append(grandTotal);
        stringBuilder.append(" CHF");
    }
}
