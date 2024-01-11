package com.iambulance.skai.test.service;

import com.iambulance.skai.test.model.ApiRequest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatisticsServiceTest {

    @Test
    public void testGenerateReport() {
        List<ApiRequest> apiRequests = Arrays.asList(
                ApiRequest.builder().ip("192.168.1.1").data("28/01/2022:10:00:00-0300").requestMethod("GET").uri("/save").requestStatus(200).build(),
                ApiRequest.builder().ip("192.168.1.2").data("28/01/2022:10:01:00-0300").requestMethod("POST").uri("/save").requestStatus(404).build(),
                ApiRequest.builder().ip("192.168.1.3").data("28/01/2022:10:02:00-0300").requestMethod("GET").uri("/save").requestStatus(200).build()
        );

        StatisticsService statisticsService = new StatisticsService();

        String report = statisticsService.generateReport(apiRequests);

        assertTrue(report.contains("Results"));
        assertTrue(report.contains("---- Top URIs ----"));
        assertTrue(report.contains("---- Requests per second ----"));
        assertTrue(report.contains("---- Counters ----"));
    }
}