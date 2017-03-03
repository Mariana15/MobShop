package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.OS;
import ua.service.OSService;



public class OSEditor extends PropertyEditorSupport{
	private final OSService osService;

	public OSEditor(OSService osService) {
		this.osService = osService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		OS os = osService.findOne(Integer.valueOf(text));
		setValue(os);
	}
}
