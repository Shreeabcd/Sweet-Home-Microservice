package com.upgrad.booking_service.controller;

import com.netflix.discovery.shared.Application;
import com.upgrad.booking_service.dto.BookingDTO;
import com.upgrad.booking_service.dto.PaymentDTO;
import com.upgrad.booking_service.entity.BookingInfoEntity;
import com.upgrad.booking_service.exception.DateRangeException;
import com.upgrad.booking_service.exception.IllegalPaymentException;
import com.upgrad.booking_service.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.zip.DataFormatException;

@RestController
@RequestMapping(value = "/hotel")
public class BookingServiceController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/booking", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingInfoEntity> createBooking(@RequestBody BookingDTO bookingDTO) throws DataFormatException, DateRangeException {
        BookingInfoEntity bookingInfoEntity = bookingService.createBooking(bookingDTO);
        return new ResponseEntity<>(bookingInfoEntity, HttpStatus.CREATED);
    }

    @PostMapping(value = "/booking/{transactionId}/transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingInfoEntity> updateTransactionId(@PathVariable (name="transactionId") int transactionId, @RequestBody PaymentDTO paymentDTO) throws IllegalPaymentException {
        System.out.println(paymentDTO.toString());
        BookingInfoEntity bookingInfoEntity = bookingService.updateTransaction(transactionId, paymentDTO);
        return new ResponseEntity<>(bookingInfoEntity, HttpStatus.CREATED);
    }


}
