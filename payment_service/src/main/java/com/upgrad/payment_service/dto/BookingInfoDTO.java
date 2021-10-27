package com.upgrad.payment_service.dto;

import java.time.LocalDateTime;

public class BookingInfoDTO {

    private int bookingId;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String aadharNumber;
    private int noOfRooms;
    private String roomNumbers;
    private int roomPrice;
    private int transactionId;
    private LocalDateTime bookedOn;

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public void setRoomNumbers(String roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }

    public int getBookingId() {
        return bookingId;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public String getRoomNumbers() {
        return roomNumbers;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }
}
