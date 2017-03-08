package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.CameraForm;
import ua.entity.Camera;
import ua.service.CameraService;

public class CameraValidator implements Validator {
	private final CameraService cameraService;

	public CameraValidator(CameraService cameraService) {
		this.cameraService = cameraService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CameraForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Camera camera = (Camera) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if (cameraService.findOne(camera.getPx()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
