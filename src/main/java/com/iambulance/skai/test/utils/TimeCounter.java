package com.iambulance.skai.test.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeCounter {

    public static String DD_MM_YYYY_HH_MM_SSZ = "dd/MM/yyyy:HH:mm:ssZ";

    private static Date textToDate(String text, String dateFormat){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        try {
            return simpleDateFormat.parse(text);
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getTimeInterval(Date startDate, Date endDate){
        StringBuilder sb = new StringBuilder();
        if (startDate != null && endDate != null){
            long timeDifferenceMillis = endDate.getTime() - startDate.getTime();
            long seconds = timeDifferenceMillis / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            if (hours > 0){
                sb.append(hours + " hours, ");
            }
            if (minutes > 0) {
                sb.append(minutes % 60 + " minutes, ");
            }
            sb.append(seconds % 60 + " seconds.");
        }
        return sb.toString();
    }

    public static Date getMinDate(List<String> listOfDates, String dateFormat){
        Date minTime = null;
        for (String date : listOfDates){
            Date currentTime = textToDate(date, dateFormat);
            if (minTime == null || currentTime.before(minTime)){
                minTime = currentTime;
            }
        }
        return minTime;
    }

    public static Date getMaxDate(List<String> listOfDates, String dateFormat){
        Date maxTime = null;
        for (String date : listOfDates){
            Date currentTime = textToDate(date, dateFormat);
            if (maxTime == null || currentTime.after(maxTime)){
                maxTime = currentTime;
            }
        }
        return maxTime;
    }
}
