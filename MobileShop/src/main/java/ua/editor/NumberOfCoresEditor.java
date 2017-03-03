package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.NumberOfCores;
import ua.service.NumberOfCoresService;


public class NumberOfCoresEditor extends PropertyEditorSupport{
	private final NumberOfCoresService numberOfCoresService;

	public NumberOfCoresEditor(NumberOfCoresService numberOfCoresService) {
		this.numberOfCoresService = numberOfCoresService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		NumberOfCores noc = numberOfCoresService.findOne(Integer.valueOf(text));
		setValue(noc);
	}
}
