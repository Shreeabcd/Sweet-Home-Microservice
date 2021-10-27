package com.upgrad.booking_service.exception;

public class IllegalPaymentException extends RuntimeException {
    public IllegalPaymentException(String invalid_mode_of_payment)
    {
        super(invalid_mode_of_payment);
    }
}
