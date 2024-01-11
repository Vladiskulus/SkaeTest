package com.iambulance.skai.test.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IPValidatorTest {

    @Test
    public void testValidIP() {
        String validIP1 = "192.168.0.1";
        String validIP2 = "10.0.0.255";
        String validIP3 = "172.16.31.0";
        String validIP4 = "255.255.255.255";

        assertTrue(IPValidator.isValidIP(validIP1));
        assertTrue(IPValidator.isValidIP(validIP2));
        assertTrue(IPValidator.isValidIP(validIP3));
        assertTrue(IPValidator.isValidIP(validIP4));
    }

    @Test
    public void testInvalidIP() {
        String invalidIP1 = "256.168.0.1";
        String invalidIP2 = "192.168.0.256";
        String invalidIP3 = "192.168.0";
        String invalidIP4 = "invalid_ip";

        assertFalse(IPValidator.isValidIP(invalidIP1));
        assertFalse(IPValidator.isValidIP(invalidIP2));
        assertFalse(IPValidator.isValidIP(invalidIP3));
        assertFalse(IPValidator.isValidIP(invalidIP4));
    }
}