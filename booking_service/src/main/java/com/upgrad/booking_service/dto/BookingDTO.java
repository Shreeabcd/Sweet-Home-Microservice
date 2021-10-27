package com.upgrad.booking_service.dto;

public class BookingDTO {
    private String fromDate;
    private String toDate;
    private String aadharNumber;
    private int numOfRooms;

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }
}
