package com.upgrad.payment_service.controller;

import com.upgrad.payment_service.dto.TransactionDTO;
import com.upgrad.payment_service.dto.TransactionDetailsDTO;
import com.upgrad.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentServiceController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createTransaction(@RequestBody  TransactionDTO transactionDTO){
        Integer transactionId = paymentService.createTransaction(transactionDTO);
        return new ResponseEntity<>(transactionId, HttpStatus.CREATED);
    }

    @GetMapping(value = "/transaction/{transactionId}")
    public ResponseEntity<TransactionDetailsDTO> retrieveTransactionId(@PathVariable (name="transactionId") int transactionId){
        TransactionDetailsDTO retrievedDetails = paymentService.retrieveTransaction(transactionId);
        return new ResponseEntity(retrievedDetails, HttpStatus.OK);
    }
}
