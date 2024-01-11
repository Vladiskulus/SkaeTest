package com.iambulance.skai.test.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateValidatorTest {

    @Test
    public void testValidDate() {
        String validDate1 = "28/01/2022:15:30:00-0300";
        String validDate2 = "15/08/2023:08:45:30+0200";

        assertTrue(DateValidator.isValidDate(validDate1));
        assertTrue(DateValidator.isValidDate(validDate2));
    }

    @Test
    public void testInvalidDate() {
        String invalidDate1 = "2022/01/28:15:30:00-0300";
        String invalidDate2 = "28-01-2022:15:30:00-0300";
        String invalidDate3 = "28/01/2022:15:30:00";
        String invalidDate4 = "invalid_date";

        assertFalse(DateValidator.isValidDate(invalidDate1));
        assertFalse(DateValidator.isValidDate(invalidDate2));
        assertFalse(DateValidator.isValidDate(invalidDate3));
        assertFalse(DateValidator.isValidDate(invalidDate4));
    }
}