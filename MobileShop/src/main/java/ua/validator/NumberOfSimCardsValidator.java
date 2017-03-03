package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.MemoryForm;
import ua.dto.form.NumberOfSimCardsForm;
import ua.entity.NumberOfSimCards;
import ua.service.MemoryService;
import ua.service.NumberOfSimCardsService;

public class NumberOfSimCardsValidator implements Validator {

	private NumberOfSimCardsService numberOfSimCardsService;

	public NumberOfSimCardsValidator(NumberOfSimCardsService numberOfSimCardsService) {
		this.numberOfSimCardsService = numberOfSimCardsService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(NumberOfSimCardsForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		
}

}
