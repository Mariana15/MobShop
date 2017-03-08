package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.FrontCameraForm;
import ua.entity.FrontCamera;
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
		FrontCamera frontCamera = (FrontCamera) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if (frontCameraService.findOne(frontCamera.getPx()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
