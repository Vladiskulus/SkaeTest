package com.iambulance.skai.test.utils;

import com.iambulance.skai.test.model.ApiRequest;

import java.util.List;
import java.util.stream.Collectors;

public class ListConverter {

    public static List<String> getDateArrayList(List<ApiRequest> apiRequests) {
        return apiRequests.stream()
                .map(ApiRequest::getData)
                .collect(Collectors.toList());
    }
}
