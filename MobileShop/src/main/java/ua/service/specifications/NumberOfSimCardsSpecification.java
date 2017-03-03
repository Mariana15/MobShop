package ua.service.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.BasicFilter;
import ua.entity.NumberOfSimCards;
import ua.entity.Producer;

public class NumberOfSimCardsSpecification  implements Specification<NumberOfSimCards>{
	private final BasicFilter filter;

	public NumberOfSimCardsSpecification(BasicFilter filter) {
		this.filter = filter;
	}
	@Override
	public Predicate toPredicate(Root<NumberOfSimCards> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("name"), filter.getSearch()+"%");
	}
}
