package com.upgrad.booking_service.exception;

import com.upgrad.booking_service.entity.BookingInfoEntity;

public class DateFormatException extends RuntimeException {

    public DateFormatException(String message) {
        super(message);
    }
}
