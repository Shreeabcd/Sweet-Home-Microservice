package com.upgrad.payment_service.service;


import com.upgrad.payment_service.dto.TransactionDTO;
import com.upgrad.payment_service.dto.TransactionDetailsDTO;

public interface PaymentService {
    public int createTransaction(TransactionDTO transactionDTO);

    public TransactionDetailsDTO retrieveTransaction(int transactionId);
}
