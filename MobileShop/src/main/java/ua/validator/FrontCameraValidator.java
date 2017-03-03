package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.FrontCameraForm;
import ua.service.FrontCameraService;



public class FrontCameraValidator implements Validator {
	private FrontCameraService frontCameraService;

	public FrontCameraValidator(FrontCameraService frontCameraService) {
		this.frontCameraService = frontCameraService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(FrontCameraForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
}
}
