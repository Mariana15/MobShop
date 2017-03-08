package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;

public interface CategoryService {
	List<Category> findAll();

	void delete(int id);

	void save(Category form);

	Category findOne(int id);

	Category findOne(String name);

	Page<Category> findAll(BasicFilter filter, Pageable pageable);
}
