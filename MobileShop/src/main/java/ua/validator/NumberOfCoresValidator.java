package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.FrontCameraForm;
import ua.dto.form.NumberOfCoresForm;
import ua.service.FrontCameraService;
import ua.service.NumberOfCoresService;

public class NumberOfCoresValidator implements Validator {
	private NumberOfCoresService numberOfCoresService;

	public NumberOfCoresValidator(NumberOfCoresService numberOfCoresService) {
		this.numberOfCoresService = numberOfCoresService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(NumberOfCoresForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
}

	}


