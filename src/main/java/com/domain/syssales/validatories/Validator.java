package com.domain.syssales.validatories;

public interface Validator {
	<T> void valid(T entitie, T request);
}
