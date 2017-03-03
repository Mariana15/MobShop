package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.CameraForm;
import ua.dto.form.DiagonalForm;
import ua.service.CameraService;
import ua.service.DiagonalService;

public class DiagonalValidator implements Validator {
	private final DiagonalService diagonalService;

	public DiagonalValidator(DiagonalService diagonalService) {
		this.diagonalService = diagonalService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(DiagonalForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
}

}
