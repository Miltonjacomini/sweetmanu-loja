package br.com.sweetmanu.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.sweetmanu.models.PaginatedList;

public class PaginatedListValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PaginatedList.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "currentList", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "count", "field.required");
		
	}

}
