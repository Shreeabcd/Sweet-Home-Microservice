package com.upgrad.payment_service.dao;

import com.upgrad.payment_service.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionDao extends JpaRepository<TransactionDetailsEntity, Integer> {
}
