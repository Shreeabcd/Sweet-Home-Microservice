package com.upgrad.payment_service.dto;

public class TransactionDetailsDTO {
    private int id;
    private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;

    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
