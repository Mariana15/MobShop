package ua.dto.form;

import java.util.ArrayList;
import java.util.List;

import ua.entity.Item;

public class NumberOfCoresForm {
	private String mame;
	private List<Item> items = new ArrayList<>();

	public NumberOfCoresForm(String name, List<Item> items) {
		super();
		this.mame = name;
		this.items = items;
	}

	public String getName() {
		return mame;
	}

	public void setName(String name) {
		this.mame = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
