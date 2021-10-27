package com.upgrad.payment_service.exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String s) {
        super(s);
    }
}
