package com.iambulance.skai.test.service;

import com.iambulance.skai.test.model.ApiRequest;
import com.iambulance.skai.test.utils.RequestValidator;
import org.springframework.stereotype.Service;

import java.util.*;

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

    private void appendTopNURIsReport(List<ApiRequest> apiRequests, StringBuilder report){
        report.append("---- Top URIs ----\n");
        Map<String, Integer> uriRequestMethodCountMap = new HashMap<>();

        for (ApiRequest apiRequest : apiRequests) {
            String key = apiRequest.getUri() + " - " + apiRequest.getRequestMethod();
            uriRequestMethodCountMap.put(key, uriRequestMethodCountMap.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : uriRequestMethodCountMap.entrySet()) {
            report.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        report.append("------------------\n");
    }

    private void appendRequestsPerSecondReport(List<ApiRequest> apiRequests, StringBuilder report) {
        Map<String, Integer> requestsPerSecondMap = new HashMap<>();

        for (ApiRequest apiRequest : apiRequests) {
            if (RequestValidator.isValidDate(apiRequest.getData())){
                String timestamp = apiRequest.getData().split("-")[0].trim();
                requestsPerSecondMap.put(timestamp, requestsPerSecondMap.getOrDefault(timestamp, 0) + 1);
            } else {
                requestsPerSecondMap.put("Not valid", requestsPerSecondMap.getOrDefault("Not valid", 0) + 1);
            }
        }
        report.append("---- Requests per second ----\n");
        requestsPerSecondMap.forEach((timestamp, count) ->
                report.append(timestamp).append(" - ").append(count).append(" request").append(count > 1 ? "s" : "").append("\n"));
        report.append("------------------\n");
    }

    private void appendCountersReport(List<ApiRequest> apiRequests, StringBuilder report) {
        Map<String, Integer> countersMap = new HashMap<>();
        int totalRows = apiRequests.size();
        int validRows = (int) apiRequests.stream().filter(this::isValidRow).count();
        int processedTime = apiRequests.size();
        countersMap.put("Total rows", totalRows);
        countersMap.put("Valid rows", validRows);
        countersMap.put("Processed total time", processedTime);

        report.append("---- Counters ----\n");
        countersMap.forEach((key, value) -> report.append(key).append(" - ").append(value).append("\n"));
        report.append("------------------\n");
    }

    private boolean isValidRow(ApiRequest apiRequest) {
        return RequestValidator.isValidIP(apiRequest.getIp())
                && RequestValidator.isValidDate(apiRequest.getData())
                && RequestValidator.isValidRequestMethod(apiRequest.getRequestMethod())
                && RequestValidator.isValidURI(apiRequest.getUri())
                && RequestValidator.isValidRequestStatus(String.valueOf(apiRequest.getRequestStatus()));
    }
}