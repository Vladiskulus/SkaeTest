package com.iambulance.skai.test.utils;

public class DateValidator {
    public static boolean isValidDate(String date) {
        String dateRegex = "\\d{2}/\\d{2}/\\d{4}:\\d{2}:\\d{2}:\\d{2}-\\d{4}";
        return date.matches(dateRegex);
    }
}
