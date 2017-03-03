package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Description;
import ua.service.DescriptionService;

public class DescriptionValidator  implements Validator{
private final DescriptionService descriptionService;
	
	public DescriptionValidator (DescriptionService descriptionService){
		this.descriptionService=descriptionService;
	}
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Description.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Description description = (Description) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","","cant be empty");
		if(descriptionService.findByName(description.getName())!=null){
			errors.rejectValue("name","", "Alredy exist");
		}
		
	}
}
