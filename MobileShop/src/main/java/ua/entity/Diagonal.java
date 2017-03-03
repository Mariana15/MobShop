package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "diagonal", indexes=@Index(columnList = "_d"))
public class Diagonal extends AbstractEntity {

	@Column(name = "_d")
	
	private Integer d;
	@OneToMany(mappedBy = "diagonal")
	private List<Item> items = new ArrayList<>();

	public Diagonal() {

	}

	public Diagonal(Integer d, List<Item> items) {
		super();
		
		this.d = d;
		this.items = items;
	}


	public Integer getD() {
		return d;
	}

	public void setD(Integer d) {
		this.d = d;
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
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
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
		Diagonal other = (Diagonal) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
