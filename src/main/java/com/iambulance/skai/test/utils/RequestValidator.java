package com.iambulance.skai.test.utils;

public class RequestValidator {

    public static boolean isValidIP(String ip) {
        String ipRegex = "^(?!0\\.)([0-9]{1,3}\\.){3}[0-9]{1,3}$";
        return ip.matches(ipRegex);
    }

    public static boolean isValidDate(String date) {
        String dateRegex = "\\d{2}/\\d{2}/\\d{4}:\\d{2}:\\d{2}:\\d{2}-\\d{4}";
        return date.matches(dateRegex);
    }

    public static boolean isValidRequestMethod(String method) {
        String methodRegex = "^(GET|PUT|POST|DELETE|PATCH|HEAD|OPTIONS)$";
        return method.matches(methodRegex);
    }

    public static boolean isValidURI(String uri) {
        return true;
    }

    public static boolean isValidRequestStatus(String status) {
        String statusRegex = "^\\d{3}$";
        return status.matches(statusRegex);
    }
}
