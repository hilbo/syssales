package com.domain.syssales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.syssales.entities.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long>{

	
}
