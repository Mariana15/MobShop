package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;
import ua.service.specifications.CategorySpecification;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void delete(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public void save(Category form) {
		categoryRepository.save(form);
	}

	@Override
	public Category findOne(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public Category findOne(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public Page<Category> findAll(BasicFilter filter, Pageable pageable) {
		return categoryRepository.findAll(new CategorySpecification(filter), pageable);
	}
}
