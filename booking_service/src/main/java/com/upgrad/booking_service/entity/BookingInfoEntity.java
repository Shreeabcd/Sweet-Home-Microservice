package com.upgrad.booking_service.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class BookingInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Column(nullable = true)
    private LocalDateTime fromDate;

    @Column(nullable = true)
    private LocalDateTime toDate;

    @Column(nullable = true)
    private String aadharNumber;

    @Column(columnDefinition = "integer default Null")
    private int noOfRooms;

    @Column(columnDefinition = "varchar(60)  default Null")
    private String roomNumbers;

    @Column(nullable = false)
    private int roomPrice;

    @Column(columnDefinition = "integer default 0")
    private int transactionId;

    @Column(nullable = true)
    private LocalDateTime bookedOn;

    @Override
    public String toString() {
        return "BookingInfoEntity{" +
                "bookingId=" + bookingId +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", noOfRooms=" + noOfRooms +
                ", roomNumbers='" + roomNumbers + '\'' +
                ", roomPrice=" + roomPrice +
                ", transactionId=" + transactionId +
                ", bookedOn=" + bookedOn +
                '}';
    }

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
