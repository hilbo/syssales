package com.domain.syssales.validatories.implementations;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import com.domain.syssales.entities.Category;
import com.domain.syssales.resources.exceptions.SpecificError;
import com.domain.syssales.services.exceptions.ServiceNotFoundException;
import com.domain.syssales.services.exceptions.ServiceValidationException;
import com.domain.syssales.validatories.Validator;

@Component
public class ValidateCategory implements Validator {
	
	@Override
	public <T> void valid(T entitie, T request) {
		List<SpecificError> errors = new ArrayList<>();
		HttpServletRequest requestTmp = (HttpServletRequest) request;
		Category category = (Category) entitie;

		if (category.getName() == null || category.getName().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("name");
			specificError.setMessage("O nome não pode ser branco ou nulo !!!!!");
			errors.add(specificError);
		}
		
		if (!errors.isEmpty()) {
			requestTmp.setAttribute("errors", errors);
			throw new ServiceValidationException("");
		}
	}
	
	public void validList(List<?> list){
		if (list.isEmpty()) {
			throw new ServiceNotFoundException("Não foram encontrados resultados para a pesquisa");
		}
	}
}
