package com.upgrad.booking_service.repository;

import com.upgrad.booking_service.entity.BookingInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingServiceDao extends JpaRepository<BookingInfoEntity, Integer> {
}
