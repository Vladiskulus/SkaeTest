package com.iambulance.skai.test.utils;

public class RequestValidator {

    public static boolean isValidRequestMethod(String method) {
        String methodRegex = "^(GET|PUT|POST|DELETE|PATCH|HEAD|OPTIONS)$";
        return method.matches(methodRegex);
    }

    public static boolean isValidRequestStatus(String status) {
        String statusRegex = "^\\d{3}$";
        return status.matches(statusRegex);
    }
}
