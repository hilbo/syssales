package com.domain.syssales.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.syssales.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
}
