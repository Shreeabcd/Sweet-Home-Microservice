package com.upgrad.payment_service.dto;

public class TransactionDTO {
    private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentMode='" + paymentMode + '\'' +
                ", bookingId=" + bookingId +
                ", upiId='" + upiId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
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
