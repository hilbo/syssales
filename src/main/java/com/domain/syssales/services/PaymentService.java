package com.domain.syssales.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.syssales.entities.Order;
import com.domain.syssales.entities.Payment;
import com.domain.syssales.repositories.OrderRepository;
import com.domain.syssales.repositories.OrderStatusRepository;
import com.domain.syssales.repositories.PaymentRepository;
import com.domain.syssales.services.exceptions.ServiceNotFoundException;
import com.domain.syssales.validatories.implementations.ValidateOrder;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Autowired
	private ValidateOrder validateOrder;
		
	public PaymentService() {
	}
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	
	public Payment findById(Long id) {
		Payment payment;
		try {
			payment = paymentRepository.findById(id).get();
			} catch (NoSuchElementException e) {
			throw new ServiceNotFoundException("Pagamento não encontrada !!");
		}
		return payment;
	}
				
	public Payment insert(Payment payment, HttpServletRequest request) {
		Order order = orderRepository.findById(payment.getOrderCod()).get();
		validateOrder.validOrderStatusForPayment(order, request);
		payment.setOrder(order);
		payment = paymentRepository.save(payment);
		order.setPayment(payment);
		order.setOrderStatus(orderStatusRepository.findById(3L).get());
		orderRepository.save(order);
		return payment;
	}
}
