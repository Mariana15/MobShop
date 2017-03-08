package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.dto.form.MemoryForm;
import ua.entity.Memory;
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
		Memory memory = (Memory) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if (memoryService.findOne(memory.getMb()) != null) {
			errors.rejectValue("name", "", "Already exist");
		}

	}

}
