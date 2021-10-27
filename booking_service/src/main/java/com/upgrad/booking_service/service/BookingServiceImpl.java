package com.upgrad.booking_service.service;

import com.upgrad.booking_service.dto.BookingDTO;
import com.upgrad.booking_service.dto.PaymentDTO;
import com.upgrad.booking_service.entity.BookingInfoEntity;
import com.upgrad.booking_service.exception.DateFormatException;
import com.upgrad.booking_service.exception.DateRangeException;
import com.upgrad.booking_service.exception.IllegalPaymentException;
import com.upgrad.booking_service.exception.RecordNotFoundException;
import com.upgrad.booking_service.repository.BookingServiceDao;
import com.upgrad.booking_service.util.BookingServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingServiceDao bookingServiceDao;

    @Autowired
    private BookingServiceUtils bookingServiceUtils;


    @Override
    public BookingInfoEntity createBooking(BookingDTO bookingDTO) throws DateFormatException, DateRangeException {
        // Set the entity before saving to DB
        BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
        // Aadhar numbers
        bookingInfoEntity.setAadharNumber(bookingDTO.getAadharNumber());
        // From Date
        bookingInfoEntity.setFromDate(bookingServiceUtils.validateDate(bookingDTO.getFromDate()));
        // To Date
        bookingInfoEntity.setToDate(bookingServiceUtils.validateDate(bookingDTO.getToDate()));
        // Validate whether from date is less than the to date
        bookingServiceUtils.validateFromToDate(bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
        // Get the number of days
        int numberOfDays = (int)bookingServiceUtils.getNumberOfDays(bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
        // number of Rooms
        bookingInfoEntity.setNoOfRooms(bookingDTO.getNumOfRooms());
        // Room Numbers
        System.out.println();
        bookingInfoEntity.setRoomNumbers(bookingServiceUtils.getRandomNumbers(bookingDTO.getNumOfRooms()));
        // Room price
        bookingInfoEntity.setRoomPrice(1000 * bookingInfoEntity.getNoOfRooms() * numberOfDays);
        // Booked on
        bookingInfoEntity.setBookedOn(LocalDateTime.now());

        return bookingServiceDao.save(bookingInfoEntity);
    }

    @Override
    public BookingInfoEntity updateTransaction(int transactionId, PaymentDTO paymentDTO) throws RecordNotFoundException, IllegalPaymentException {
        // Check the payment method
        bookingServiceUtils.checkPaymentMethod(paymentDTO.getPaymentMode());

        // Retrieve the date from the database
        BookingInfoEntity savedData = bookingServiceDao.findById(paymentDTO.getBookingId()).orElseThrow(
                () ->  new RecordNotFoundException("Invalid Booking Id"));
        // Update the transactionId
        savedData.setTransactionId(transactionId);
        // Update the data in the database
        return bookingServiceDao.save(savedData);
    }


}
