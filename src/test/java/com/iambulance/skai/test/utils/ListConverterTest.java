package com.iambulance.skai.test.utils;

import com.iambulance.skai.test.model.ApiRequest;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListConverterTest {

    @Test
    public void testGetDateArrayList() {
        ApiRequest apiRequest1 = ApiRequest.builder().ip("127.0.0.1").data("28/07/2006:11:26:04-0300").requestMethod("GET").uri("/save").requestStatus(200).build();
        ApiRequest apiRequest2 = ApiRequest.builder().ip("192.168.1.1").data("28/07/2006:10:25:04-0300").requestMethod("POST").uri("/save").requestStatus(404).build();
        List<ApiRequest> apiRequests = List.of(apiRequest1, apiRequest2);

        List<String> result = ListConverter.getDateArrayList(apiRequests);

        List<String> expected = List.of("data1", "data2");
        assertEquals(expected, result);
    }
}
