package com.iambulance.skai.test.service;

import com.iambulance.skai.test.model.ApiRequest;
import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.*;

@Service
public class ApiService {

    public List<ApiRequest> processCsvFile(MultipartFile file) {
        List<ApiRequest> apiRequests = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()), ';')) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 5) {
                    apiRequests.add(ApiRequest.builder()
                            .ip(line[0])
                            .data(line[1])
                            .requestMethod(line[2])
                            .uri(line[3])
                            .requestStatus(Integer.parseInt(line[4]))
                            .build()
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return apiRequests;
    }
}