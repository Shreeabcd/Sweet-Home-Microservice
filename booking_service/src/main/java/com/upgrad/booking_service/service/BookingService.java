package com.upgrad.booking_service.service;

import com.upgrad.booking_service.dto.BookingDTO;
import com.upgrad.booking_service.dto.PaymentDTO;
import com.upgrad.booking_service.entity.BookingInfoEntity;
import com.upgrad.booking_service.exception.DateRangeException;
import com.upgrad.booking_service.exception.IllegalPaymentException;
import com.upgrad.booking_service.exception.RecordNotFoundException;

import java.util.zip.DataFormatException;

public interface BookingService {

    public BookingInfoEntity createBooking(BookingDTO bookingDTO) throws DataFormatException, DateRangeException;

    public BookingInfoEntity updateTransaction(int transactionId, PaymentDTO paymentDTO) throws RecordNotFoundException, IllegalPaymentException;
}
