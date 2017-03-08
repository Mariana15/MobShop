package ua.dto.form;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Item;

public class NumberOfSimCardsForm {
	private String name;
	private List<Item> items = new ArrayList<>();

	public NumberOfSimCardsForm(String name, List<Item> items) {
		super();
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
