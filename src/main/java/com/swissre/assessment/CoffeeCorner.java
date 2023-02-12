package com.swissre.assessment;

import java.util.Arrays;

public class CoffeeCorner {

    public static void main(String[] args) {
        String[] input = {"large coffee with extra milk, small coffee with special roast, bacon roll, orange juice"};
        Arrays.stream(input).forEach(System.out::println);
    }

    public static String calculateReceipt() {
        throw new UnsupportedOperationException();
    }
}
