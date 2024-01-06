package com.iambulance.skai.test.utils;

import com.iambulance.skai.test.model.ApiRequest;

import java.util.ArrayList;
import java.util.List;

public class ListConverter {

    public static ArrayList<String> getDateArrayList(List<ApiRequest> apiRequests){
        ArrayList<String> listOfDates = new ArrayList<>();
        for (ApiRequest obj : apiRequests){
            listOfDates.add(obj.getData());
        }
        return listOfDates;
    }
}
