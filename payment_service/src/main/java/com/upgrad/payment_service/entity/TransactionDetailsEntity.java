package com.upgrad.payment_service.entity;

import javax.persistence.*;

@Entity(name = "Transaction")
public class TransactionDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Column(columnDefinition = "varchar(30)  default Null")
    private String paymentMode;

    @Column(nullable = false)
    private int bookingId;

    private String upiId;

    private String cardNumber;

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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

    public int getTransactionId() {
        return transactionId;
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
