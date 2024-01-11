package com.iambulance.skai.test.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class URIValidatorTest {

    @Test
    public void testValidURI() {
        String validURI1 = "user";
        String validURI2 = "user/try";
        String validURI3 = "save";
        String validURI4 = "save/";

        assertTrue(URIValidator.isValidURI(validURI1));
        assertTrue(URIValidator.isValidURI(validURI2));
        assertTrue(URIValidator.isValidURI(validURI3));
        assertTrue(URIValidator.isValidURI(validURI4));
    }

    @Test
    public void testInvalidURI() {
        String invalidURI1 = "users";
        String invalidURI2 = "user/test";
        String invalidURI3 = "save-data";
        String invalidURI4 = "invalid";

        assertFalse(URIValidator.isValidURI(invalidURI1));
        assertFalse(URIValidator.isValidURI(invalidURI2));
        assertFalse(URIValidator.isValidURI(invalidURI3));
        assertFalse(URIValidator.isValidURI(invalidURI4));
    }
}
