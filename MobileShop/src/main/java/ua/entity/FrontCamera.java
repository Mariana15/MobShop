package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fc", indexes=@Index(columnList = "_px"))
public class FrontCamera extends AbstractEntity {
	@Column(name = "_px")
	
	private Integer px;
	@OneToMany(mappedBy = "fc")
	private List<Item> items = new ArrayList<>();

	public FrontCamera() {

	}

	public FrontCamera(Integer px, List<Item> items) {
		super();
		
		this.px = px;
		this.items = items;
	}

	

	public Integer getPx() {
		return px;
	}

	public void setPx(Integer px) {
		this.px = px;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((px == null) ? 0 : px.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrontCamera other = (FrontCamera) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (px == null) {
			if (other.px != null)
				return false;
		} else if (!px.equals(other.px))
			return false;
		return true;
	}

}
