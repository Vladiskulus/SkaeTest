package com.iambulance.skai.test.service;

import com.iambulance.skai.test.model.ApiRequest;
import com.iambulance.skai.test.utils.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    public String generateReport(List<ApiRequest> list) {
        StringBuilder report = new StringBuilder();

        report.append("Results:\n");
        appendTopNURIsReport(list, report);
        appendRequestsPerSecondReport(list, report);
        appendCountersReport(list, report);

        return report.toString();
    }

    private void appendTopNURIsReport(List<ApiRequest> apiRequests, StringBuilder report) {
        report.append("---- Top URIs ----\n");
        Map<String, Long> uriRequestMethodCountMap = apiRequests.stream()
                .collect(Collectors.groupingBy(
                        apiRequest -> apiRequest.getUri() + " - " + apiRequest.getRequestMethod(),
                        Collectors.counting()
                ));
        uriRequestMethodCountMap.forEach((key, value) -> report.append(key).append(" ").append(value).append("\n"));
        report.append("------------------\n");
    }

    private void appendRequestsPerSecondReport(List<ApiRequest> apiRequests, StringBuilder report) {
        report.append("---- Requests per second ----\n");
        Map<String, Integer> requestsPerSecondMap = apiRequests.stream()
                .filter(apiRequest -> DateValidator.isValidDate(apiRequest.getData()))
                .collect(Collectors.groupingBy(
                        apiRequest -> apiRequest.getData().split("-")[0].trim(),
                        Collectors.summingInt(e -> 1)
                ));
        requestsPerSecondMap.forEach((timestamp, count) ->
                report.append(timestamp).append(" - ").append(count).append(" request").append(count > 1 ? "s" : "").append("\n"));
        report.append("------------------\n");
    }

    private void appendCountersReport(List<ApiRequest> apiRequests, StringBuilder report) {
        Map<String, String> countersMap = new HashMap<>();
        int totalRows = apiRequests.size();
        int validRows = (int) apiRequests.stream().filter(this::isValidRow).count();
        String processedTime = TimeCounter.getTimeInterval(TimeCounter.getMinDate(ListConverter.getDateArrayList(apiRequests), TimeCounter.DD_MM_YYYY_HH_MM_SSZ), TimeCounter.getMaxDate(ListConverter.getDateArrayList(apiRequests), TimeCounter.DD_MM_YYYY_HH_MM_SSZ));
        countersMap.put("Total rows", String.valueOf(totalRows));
        countersMap.put("Valid rows", String.valueOf(validRows));
        countersMap.put("Processed total time", processedTime);

        report.append("---- Counters ----\n");
        countersMap.forEach((key, value) -> report.append(key).append(" - ").append(value).append("\n"));
        report.append("------------------\n");
    }



    private boolean isValidRow(ApiRequest apiRequest) {
        return IPValidator.isValidIP(apiRequest.getIp())
                && DateValidator.isValidDate(apiRequest.getData())
                && RequestValidator.isValidRequestMethod(apiRequest.getRequestMethod())
                && URIValidator.isValidURI(apiRequest.getUri())
                && RequestValidator.isValidRequestStatus(String.valueOf(apiRequest.getRequestStatus()));
    }
}