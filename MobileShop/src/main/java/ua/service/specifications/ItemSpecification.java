package ua.service.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.ItemFilter;
import ua.entity.Item;

public class ItemSpecification implements Specification<Item> {
	private final ItemFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	public ItemSpecification(ItemFilter filter) {
		this.filter = filter;
	}

	private void filterByProducer(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getProducerIds().isEmpty()) {
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}

	private void filterByCamera(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getCameraIds().isEmpty()) {
			predicates.add(root.get("camera").in(filter.getCameraIds()));
		}
	}

	private void filterByColor(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getColorIds().isEmpty()) {
			predicates.add(root.get("color").in(filter.getColorIds()));
		}
	}

	private void filterByCategory(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getCategoryIds().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryIds()));
		}
	}

	private void filterByDiagonal(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getDiagonalIds().isEmpty()) {
			predicates.add(root.get("diagonal").in(filter.getDiagonalIds()));
		}
	}

	private void filterByFc(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getFcIds().isEmpty()) {
			predicates.add(root.get("fc").in(filter.getFcIds()));
		}
	}

	private void filterByMemory(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getMemoryIds().isEmpty()) {
			predicates.add(root.get("memory").in(filter.getMemoryIds()));
		}
	}

	private void filterByNoc(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getNocIds().isEmpty()) {
			predicates.add(root.get("noc").in(filter.getNocIds()));
		}
	}

	private void filterByNosc(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getNoscIds().isEmpty()) {
			predicates.add(root.get("nosc").in(filter.getNoscIds()));
		}
	}

	private void filterByOs(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getOsIds().isEmpty()) {
			predicates.add(root.get("os").in(filter.getOsIds()));
		}
	}

	private void filterByTs(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getTsIds().isEmpty()) {
			predicates.add(root.get("ts").in(filter.getTsIds()));
		}
	}

	private void filterByDescription(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getDescriptionIds().isEmpty()) {
			predicates.add(root.get("description").in(filter.getTsIds()));
		}
	}

	private void filterByPrice(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (filter.getMax() != null && filter.getMin() != null) {
			predicates.add(cb.between(root.get("price"), filter.getMin(), filter.getMax()));
		} else if (filter.getMax() != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get("price"), filter.getMax()));
		} else if (filter.getMin() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filter.getMin()));
		}
	}

	private void filterBySearch(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(cb.like(root.get("name"), filter.getSearch() + "%"));
		}
	}

	private void fetch(Root<Item> root, CriteriaQuery<?> query) {
		if (query.getResultType() != Long.class) {
			root.fetch("category", JoinType.LEFT);
			root.fetch("producer", JoinType.LEFT);
			root.fetch("color", JoinType.LEFT);
			root.fetch("camera", JoinType.LEFT);
			root.fetch("diagonal", JoinType.LEFT);
			root.fetch("fc", JoinType.LEFT);
			root.fetch("memory", JoinType.LEFT);
			root.fetch("noc", JoinType.LEFT);
			root.fetch("nosc", JoinType.LEFT);
			root.fetch("os", JoinType.LEFT);
			root.fetch("ts", JoinType.LEFT);
			root.fetch("description", JoinType.LEFT);
		}
	}

	@Override
	public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByPrice(root, query, cb);
		filterByProducer(root, query, cb);
		filterByColor(root, query, cb);
		filterByCategory(root, query, cb);
		filterByCamera(root, query, cb);
		filterByDiagonal(root, query, cb);
		filterByFc(root, query, cb);
		filterByMemory(root, query, cb);
		filterByNoc(root, query, cb);
		filterByNosc(root, query, cb);
		filterByOs(root, query, cb);
		filterByTs(root, query, cb);
		filterByDescription(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}

}
