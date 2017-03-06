package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.FrontCamera;
import ua.service.FrontCameraService;


public class FrontCameraEditor extends PropertyEditorSupport{
	private final FrontCameraService frontCameraService;

	public FrontCameraEditor(FrontCameraService frontCameraService) {
		this.frontCameraService = frontCameraService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		FrontCamera fc = frontCameraService.findOne(Integer.valueOf(text));
		setValue(fc);
	}
}
