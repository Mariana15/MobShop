package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.NumberOfCoresForm;
import ua.entity.TypeSim;
import ua.service.NumberOfCoresService;
import ua.service.TypeSimService;

public class TypeSimValidator implements Validator{
	private final TypeSimService typeSimService;

	public TypeSimValidator(TypeSimService typeSimService) {
		this.typeSimService = typeSimService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(TypeSim.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TypeSim typeSim = (TypeSim) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if(typeSimService.findOne(typeSim.getName())!=null){
			errors.rejectValue("name", "", "Already exist");
		}
	}
}
