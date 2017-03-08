package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.NumberOfSimCards;
import ua.service.NumberOfSimCardsService;

public class NumberOfSimCardsEditor extends PropertyEditorSupport {
	private final NumberOfSimCardsService numberOfSimCardsService;

	public NumberOfSimCardsEditor(NumberOfSimCardsService numberOfSimCardsService) {
		this.numberOfSimCardsService = numberOfSimCardsService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		NumberOfSimCards nosc = numberOfSimCardsService.findOne(Integer.valueOf(text));
		setValue(nosc);
	}
}
