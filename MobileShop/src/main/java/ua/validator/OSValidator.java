package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.OS;
import ua.service.OSService;

public class OSValidator implements Validator {
	private final OSService osService;

	public OSValidator(OSService osService) {
		this.osService = osService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(OS.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OS os = (OS) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if (osService.findOne(os.getName()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
