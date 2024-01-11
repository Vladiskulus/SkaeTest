package com.iambulance.skai.test.service;

import com.iambulance.skai.test.model.ApiRequest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiServiceTest {

    @Test
    public void testProcessCsvFile() throws IOException {
        String csvContent = "192.168.2.212;28/07/2006:10:27:10-0300;GET;/user/try/;200\n" +
                "192.168.2.212;28/07/2006:10:22:04-0300;GET;/;200\n" +
                "192.168.2.220;28/07/2006:10:25:04-0300;PUT;/save/;200\n" +
                "192.168.2.111;28/07/2006:10:25:04-0300;PUT;/save/;403";

        InputStream inputStream = IOUtils.toInputStream(csvContent, Charset.defaultCharset());
        MockMultipartFile file = new MockMultipartFile("file", "test.csv", "text/csv", inputStream);

        ApiService apiService = new ApiService();

        List<ApiRequest> apiRequests = apiService.processCsvFile(file);

        assertEquals(4, apiRequests.size());
    }
}