package com.iambulance.skai.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeCounter {

    public static String DD_MM_YYYY_HH_MM_SSZ = "dd/MM/yyyy:HH:mm:ssZ";

    private static Date textToDate(String date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse date: " + date, e);
        }
    }

    public static String getTimeInterval(Date startDate, Date endDate){
        StringBuilder sb = new StringBuilder();
        if (startDate != null && endDate != null){
            long timeDifferenceMillis = endDate.getTime() - startDate.getTime();
            long seconds = timeDifferenceMillis / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            if (hours > 0){
                sb.append(hours).append(" hours, ");
            }
            if (minutes > 0) {
                sb.append(minutes % 60).append(" minutes, ");
            }
            sb.append(seconds % 60).append(" seconds.");
        }
        return sb.toString();
    }

    public static Date getMinDate(List<String> listOfDates, String dateFormat) {
        return listOfDates.stream()
                .map(date -> textToDate(date, dateFormat))
                .reduce(null, (minDate, currentDate) ->
                        (minDate == null || currentDate.before(minDate)) ? currentDate : minDate);
    }

    public static Date getMaxDate(List<String> listOfDates, String dateFormat) {
        return listOfDates.stream()
                .map(date -> textToDate(date, dateFormat))
                .reduce(null, (maxDate, currentDate) ->
                        (maxDate == null || currentDate.after(maxDate)) ? currentDate : maxDate);
    }
}
