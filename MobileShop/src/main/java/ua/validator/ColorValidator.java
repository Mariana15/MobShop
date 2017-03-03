package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.CameraForm;
import ua.entity.Color;
import ua.service.CameraService;
import ua.service.ColorService;

public class ColorValidator implements Validator{
	
	private final ColorService colorService;

	public ColorValidator(ColorService colorService) {
		this.colorService = colorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Color.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Color color = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if(colorService.findOne(color.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
