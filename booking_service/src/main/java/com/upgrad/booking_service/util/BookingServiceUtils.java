package com.upgrad.booking_service.util;

import com.upgrad.booking_service.exception.DateFormatException;
import com.upgrad.booking_service.exception.DateRangeException;
import com.upgrad.booking_service.exception.IllegalPaymentException;
import org.springframework.stereotype.Component;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.zip.DataFormatException;

@Component
public class BookingServiceUtils {

    /**
     * Generate a series of numbers
     * @param count :
     * @return series of numbers for the count passed
     */
    public static String getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }

        //Convert the array list into a string
        return String.join(",", numberList);

    }

    /**
     * Validate wherether the date is in the right foramt
     * @param date
     * @return Date.
     * @throws DataFormatException
     */
    public static LocalDateTime validateDate(String date) throws DateFormatException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate ld = LocalDate.parse(date, dateFormatter);
            return ld.atStartOfDay();
        } catch(DateTimeParseException e){
            throw new DateFormatException("Invalid Date Format : YYYY-MM-DD");
        }

    }

    /**
     * Validate whether the from date is before the To date
     * @param fromDate
     * @param toDate
     * @throws DateRangeException
     */
    public static void validateFromToDate(LocalDateTime fromDate, LocalDateTime toDate) throws DateRangeException {
        System.out.println("from " + fromDate +  " To " + toDate);

        if (toDate.compareTo(fromDate) < 0){
            throw new DateRangeException("From Date needs to be Before the To Date");
        }
    }

    /**
     * Get the number of days between 2 dates
     * @param fromDate
     * @param toDate
     * @return number of days
     */
    public long getNumberOfDays(LocalDateTime fromDate, LocalDateTime toDate) {
        return Duration.between(fromDate, toDate).toDays();
        //long diff = toDate.getTime() - fromDate.getTime();
        //return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void checkPaymentMethod(String paymentMode) throws IllegalPaymentException {
        if (!paymentMode.equals("CARD") && !paymentMode.equals("UPI"))
            throw new IllegalPaymentException("Invalid mode of payment");


    }
}
