package com.iambulance.skai.test.controller;

import com.iambulance.skai.test.model.ApiRequest;
import com.iambulance.skai.test.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiService apiService;
    private final StatisticsService statisticsService;

    @Autowired
    public ApiController(ApiService apiService, StatisticsService statisticsService) {
        this.apiService = apiService;
        this.statisticsService = statisticsService;
    }

    @PostMapping("/upload")
    @ApiOperation(value = "Upload CSV file and process statistics")
    public ResponseEntity<String> processCsvFile(@RequestParam("file") MultipartFile file) {
        List<ApiRequest> apiRequests = apiService.processCsvFile(file);
        String formattedResults = statisticsService.generateReport(apiRequests);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok()
                .headers(headers)
                .body(formattedResults);
    }
}