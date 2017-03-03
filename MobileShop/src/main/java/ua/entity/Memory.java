package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "memory", indexes=@Index(columnList = "_mb"))
public class Memory extends AbstractEntity {

	@Column(name = "_mb")
	
	private Integer mb;
	@OneToMany(mappedBy = "memory")
	private List<Item> items = new ArrayList<>();

	public Memory() {

	}

	public Memory(Integer mb, List<Item> items) {
		super();
		
		this.mb = mb;
		this.items = items;
	}

	

	public Integer getMb() {
		return mb;
	}

	public void setMb(Integer mb) {
		this.mb = mb;
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
		result = prime * result + ((mb == null) ? 0 : mb.hashCode());
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
		Memory other = (Memory) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (mb == null) {
			if (other.mb != null)
				return false;
		} else if (!mb.equals(other.mb))
			return false;
		return true;
	}

}
