package com.upgrad.payment_service.service;

import com.upgrad.payment_service.dao.TransactionDao;
import com.upgrad.payment_service.dto.PaymentDTO;
import com.upgrad.payment_service.dto.BookingInfoDTO;
import com.upgrad.payment_service.dto.TransactionDTO;
import com.upgrad.payment_service.dto.TransactionDetailsDTO;
import com.upgrad.payment_service.entity.TransactionDetailsEntity;
import com.upgrad.payment_service.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bookingApp.url}")
    private String bookingUrl;

    @Override
    public int createTransaction(TransactionDTO transactionDTO) {
        TransactionDetailsEntity transactionDetailsEntity = new TransactionDetailsEntity();
        transactionDetailsEntity.setBookingId(transactionDTO.getBookingId());
        transactionDetailsEntity.setPaymentMode(transactionDTO.getPaymentMode());
        transactionDetailsEntity.setCardNumber(transactionDTO.getCardNumber());
        transactionDetailsEntity.setUpiId(transactionDTO.getUpiId());
        // Save the data into the database
        TransactionDetailsEntity savedData = transactionDao.save(transactionDetailsEntity);
        // Call the booking service API to update the transaction id
        Map<String, Integer> uriVar = new HashMap<>();
        uriVar.put("transactionId", savedData.getTransactionId());


        PaymentDTO bookingDTO = new PaymentDTO();
        bookingDTO.setBookingId(savedData.getBookingId());
        bookingDTO.setPaymentMode(savedData.getPaymentMode());
        bookingDTO.setCardNumber(savedData.getCardNumber());
        bookingDTO.setUpiId(savedData.getUpiId());


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PaymentDTO> body = new HttpEntity<>(bookingDTO, headers);
        System.out.println(body.toString());
        BookingInfoDTO bookingInfo = restTemplate.postForObject(bookingUrl, body, BookingInfoDTO.class, uriVar);

        String message = "Booking confirmed for user with aadhaar number: "
                + bookingInfo.getAadharNumber()
                +    "    |    "
                + "Here are the booking details: " +
                "  " + bookingInfo.toString();

        System.out.println(message);
        return savedData.getTransactionId();
    }

    @Override
    public TransactionDetailsDTO retrieveTransaction(int transactionId) {
        TransactionDetailsEntity retrievedData = transactionDao.findById(transactionId).orElseThrow(
                () -> new RecordNotFoundException("No details found for Id " + transactionId));
        // Transform the Entity data to DTO
        TransactionDetailsDTO transactionDetailsDTO = new TransactionDetailsDTO();
        transactionDetailsDTO.setId(retrievedData.getTransactionId());
        transactionDetailsDTO.setBookingId(retrievedData.getBookingId());
        transactionDetailsDTO.setPaymentMode(retrievedData.getPaymentMode());
        transactionDetailsDTO.setCardNumber(retrievedData.getCardNumber());
        transactionDetailsDTO.setUpiId(retrievedData.getUpiId());

        return transactionDetailsDTO;
    }
}
