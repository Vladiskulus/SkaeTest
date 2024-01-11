package com.iambulance.skai.test.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeCounterTest {

    @Test
    public void testGetTimeInterval() throws ParseException {
        String dateFormat = TimeCounter.DD_MM_YYYY_HH_MM_SSZ;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date startDate = sdf.parse("01/01/2022:12:00:00+0000");
        Date endDate = sdf.parse("01/01/2022:14:30:45+0000");

        String result = TimeCounter.getTimeInterval(startDate, endDate);

        assertEquals("2 hours, 30 minutes, 45 seconds.", result);
    }

    @Test
    public void testGetMinDate() throws ParseException {
        String dateFormat = TimeCounter.DD_MM_YYYY_HH_MM_SSZ;
        List<String> dates = Arrays.asList(
                "01/01/2022:10:30:00+0000",
                "01/01/2022:12:45:00+0000",
                "01/01/2022:09:15:30+0000"
        );

        Date result = TimeCounter.getMinDate(dates, dateFormat);

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        assertEquals(sdf.parse("01/01/2022:09:15:30+0000"), result);
    }

    @Test
    public void testGetMaxDate() throws ParseException {
        String dateFormat = TimeCounter.DD_MM_YYYY_HH_MM_SSZ;
        List<String> dates = Arrays.asList(
                "01/01/2022:10:30:00+0000",
                "01/01/2022:12:45:00+0000",
                "01/01/2022:09:15:30+0000"
        );

        Date result = TimeCounter.getMaxDate(dates, dateFormat);

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        assertEquals(sdf.parse("01/01/2022:12:45:00+0000"), result);
    }
}