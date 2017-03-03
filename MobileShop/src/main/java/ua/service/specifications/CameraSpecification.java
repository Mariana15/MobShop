package ua.service.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.Producer;

public class CameraSpecification  implements Specification<Camera>{
	private final BasicFilter filter;

	public CameraSpecification(BasicFilter filter) {
		this.filter = filter;
	}
	@Override
	public Predicate toPredicate(Root<Camera> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("name"), filter.getSearch()+"%");
	}
}