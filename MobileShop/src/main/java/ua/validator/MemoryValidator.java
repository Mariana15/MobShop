package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.FrontCameraForm;
import ua.dto.form.MemoryForm;
import ua.service.FrontCameraService;
import ua.service.MemoryService;

public class MemoryValidator implements Validator {

	private MemoryService memoryService;

	public MemoryValidator(MemoryService memoryService) {
		this.memoryService = memoryService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(MemoryForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
}

}
