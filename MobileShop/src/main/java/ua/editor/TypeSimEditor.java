package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.TypeSim;
import ua.service.TypeSimService;



public class TypeSimEditor extends PropertyEditorSupport{
	private final TypeSimService typeSimService;

	public TypeSimEditor(TypeSimService typeSimService) {
		this.typeSimService = typeSimService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TypeSim ts = typeSimService.findOne(Integer.valueOf(text));
		setValue(ts);
	}
}
