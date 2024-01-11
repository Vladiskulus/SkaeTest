package com.iambulance.skai.test.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequestValidatorTest {

    @Test
    public void testValidRequestMethod() {
        String validMethod1 = "GET";
        String validMethod2 = "PUT";
        String validMethod3 = "POST";
        String validMethod4 = "DELETE";
        String validMethod5 = "PATCH";
        String validMethod6 = "HEAD";
        String validMethod7 = "OPTIONS";

        assertTrue(RequestValidator.isValidRequestMethod(validMethod1));
        assertTrue(RequestValidator.isValidRequestMethod(validMethod2));
        assertTrue(RequestValidator.isValidRequestMethod(validMethod3));
        assertTrue(RequestValidator.isValidRequestMethod(validMethod4));
        assertTrue(RequestValidator.isValidRequestMethod(validMethod5));
        assertTrue(RequestValidator.isValidRequestMethod(validMethod6));
        assertTrue(RequestValidator.isValidRequestMethod(validMethod7));
    }

    @Test
    public void testInvalidRequestMethod() {
        String invalidMethod1 = "INVALID";
        String invalidMethod2 = "post";
        String invalidMethod3 = "PUTT";
        String invalidMethod4 = "Get";

        assertFalse(RequestValidator.isValidRequestMethod(invalidMethod1));
        assertFalse(RequestValidator.isValidRequestMethod(invalidMethod2));
        assertFalse(RequestValidator.isValidRequestMethod(invalidMethod3));
        assertFalse(RequestValidator.isValidRequestMethod(invalidMethod4));
    }

    @Test
    public void testValidRequestStatus() {
        String validStatus1 = "200";
        String validStatus2 = "404";
        String validStatus3 = "500";

        assertTrue(RequestValidator.isValidRequestStatus(validStatus1));
        assertTrue(RequestValidator.isValidRequestStatus(validStatus2));
        assertTrue(RequestValidator.isValidRequestStatus(validStatus3));
    }

    @Test
    public void testInvalidRequestStatus() {
        String invalidStatus1 = "OK";
        String invalidStatus2 = "4000";
        String invalidStatus3 = "abc";

        assertFalse(RequestValidator.isValidRequestStatus(invalidStatus1));
        assertFalse(RequestValidator.isValidRequestStatus(invalidStatus2));
        assertFalse(RequestValidator.isValidRequestStatus(invalidStatus3));
    }
}
