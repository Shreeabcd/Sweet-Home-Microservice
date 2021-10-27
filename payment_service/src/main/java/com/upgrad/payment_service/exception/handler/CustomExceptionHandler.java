package com.upgrad.payment_service.exception.handler;

import com.upgrad.payment_service.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity handleRecordNotFoundException(RecordNotFoundException e){
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("message", e.getLocalizedMessage());
        errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
