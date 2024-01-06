package com.iambulance.skai.test.utils;

public class URIValidator {

    public static boolean isValidURI(String uri) {
        String uriRegex = "^(?:user(?:/try)?|save)/?$";
        return uri.matches(uriRegex);
    }
}
