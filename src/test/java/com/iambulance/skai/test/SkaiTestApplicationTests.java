package com.iambulance.skai.test;

import com.iambulance.skai.test.model.ApiRequest;
import com.iambulance.skai.test.service.ApiService;
import com.iambulance.skai.test.service.StatisticsService;
import com.iambulance.skai.test.utils.RequestValidator;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SkaiTestApplicationTests {

	@InjectMocks
	private ApiService apiService;

	@Mock
	private CSVReader csvReader;

	@Test
	void testProcessCsvFile() throws Exception {
		// Arrange
		String csvContent = "123.456.789.1;12/34/5678:12:34:56-5678;GET;/example/uri;200";
		MultipartFile multipartFile = new MockMultipartFile("file.csv", new ByteArrayInputStream(csvContent.getBytes()));

		List<ApiRequest> expectedApiRequests = List.of(
				new ApiRequest("123.456.789.1", "12/34/5678:12:34:56-5678", "GET", "/example/uri", 200)
		);

		MockitoAnnotations.openMocks(this);
		when(csvReader.readNext()).thenReturn(csvContent.split(";"));

		// Act
		List<ApiRequest> result = apiService.processCsvFile(multipartFile);

		// Assert
		assertEquals(expectedApiRequests, result);
	}

}
