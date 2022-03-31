package com.domain.syssales.validatories.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.domain.syssales.entities.OrderItem;
import com.domain.syssales.resources.exceptions.SpecificError;
import com.domain.syssales.services.exceptions.ServiceValidationException;
import com.domain.syssales.validatories.Validator;
@Component
public class ValidateOrderItem implements Validator {
		
	public ValidateOrderItem() {
	}
	
	@Override
	public <T> void valid(T entitie, T request) {
		List<SpecificError> errors = new ArrayList<>();
		HttpServletRequest requestTmp = (HttpServletRequest) request;
		OrderItem orderItem = (OrderItem) entitie;

		if (orderItem.getQuantity() == null || orderItem.getQuantity().toString().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("quantity");
			specificError.setMessage("A quantidade não pode ser branco ou nulo !!");
			errors.add(specificError);
		}
		
		if (orderItem.getOrderId() == null || orderItem.getOrderId().toString().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("orderId");
			specificError.setMessage("O código do pedido não pode ser branco ou nulo !!");
			errors.add(specificError);
		}
		if(orderItem.getProduct() == null || orderItem.getProduct().toString().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("product");
			specificError.setMessage("O produto não pode ser branco ou nulo !!");
			errors.add(specificError);
		}
		
		if (!errors.isEmpty()) {
			requestTmp.setAttribute("errors", errors);
			throw new ServiceValidationException("");
		}
	}
}
