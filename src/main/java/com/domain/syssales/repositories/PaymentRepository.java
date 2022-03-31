package com.domain.syssales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.syssales.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	
}
