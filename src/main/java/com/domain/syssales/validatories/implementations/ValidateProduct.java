package com.domain.syssales.validatories.implementations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.domain.syssales.entities.Category;
import com.domain.syssales.entities.Product;
import com.domain.syssales.resources.exceptions.SpecificError;
import com.domain.syssales.services.CategoryService;
import com.domain.syssales.services.exceptions.ServiceNotFoundException;
import com.domain.syssales.services.exceptions.ServiceValidationException;
import com.domain.syssales.validatories.Validator;

@Component
public class ValidateProduct implements Validator {

	@Override
	public <T> void valid(T entitie, T request) {
		List<SpecificError> errors = new ArrayList<>();
		HttpServletRequest requestTmp = (HttpServletRequest) request;
		Product product = (Product) entitie;

		if (product.getName() == null || product.getName().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("name");
			specificError.setMessage("O nome não pode ser branco ou nulo !!");
			errors.add(specificError);
		}
		if (product.getDescription() == null || product.getDescription().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("description");
			specificError.setMessage("A descrição não pode ser branco ou nulo !!");
			errors.add(specificError);
		}

		if (product.getImgUrl() == null || product.getImgUrl().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("imgUrl");
			specificError.setMessage("A ImgUrl não pode ser branco ou nulo !!");
			errors.add(specificError);
		}

		if (product.getCategory() == null || product.getCategory().toString().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("categoria");
			specificError.setMessage("A Categoria não pode ser branco ou nulo !!");
			errors.add(specificError);
		}

		if (product.getPrice() == null || product.getPrice().toString().equals("")) {
			SpecificError specificError = new SpecificError();
			specificError.setField("price");
			specificError.setMessage("A Valor não pode ser branco ou nulo !!");
			errors.add(specificError);
		}

		if (product.getCategory() == null) {
			SpecificError specificError = new SpecificError();
			specificError.setField("categoria");
			specificError.setMessage("A Categoria não pode ser branco ou nulo !!");
			errors.add(specificError);
		}

		if (!errors.isEmpty()) {
			requestTmp.setAttribute("errors", errors);
			throw new ServiceValidationException("");
		}
	}

	public void ValidAge(LocalDateTime birthDay, HttpServletRequest request) {
		List<SpecificError> errors = new ArrayList<>();
		HttpServletRequest requestTmp = (HttpServletRequest) request;
		LocalDateTime correntDate = LocalDateTime.now();
		Integer age = 0;
		age = correntDate.getYear() - birthDay.getYear();
		if (age < 18) {
			SpecificError specificError = new SpecificError();
			specificError.setMessage("A idade não pode ser menor que 18 anos !");
			specificError.setField("birthDay");
			errors.add(specificError);
		}
		if (!errors.isEmpty()) {
			requestTmp.setAttribute("errors", errors);
			throw new ServiceValidationException("");
		}
	}

	public void validCategory(Product product, CategoryService categoryService) {
		for (Category category : product.getCategory()) {
			categoryService.findById(category.getId());
		}
	}
	
	public void validList(List<?> list){
		if (list.isEmpty()) {
			throw new ServiceNotFoundException("Não foram encontrados resultados para a pesquisa");
		}
	}
}
