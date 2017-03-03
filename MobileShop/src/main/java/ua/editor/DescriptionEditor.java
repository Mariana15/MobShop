package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Description;
import ua.service.DescriptionService;

public class DescriptionEditor extends PropertyEditorSupport {

	private final DescriptionService service;
	
	public DescriptionEditor(DescriptionService service){
		this.service = service;
		
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		Description description = service.findOne(Integer.valueOf(text));
		setValue(description);
	}
}
