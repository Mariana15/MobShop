package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Producer;
import ua.repository.CategoryRepository;
import ua.repository.ColorRepository;
import ua.service.ColorService;
import ua.service.specifications.ColorSpecification;

@Service
public class ColorServiceImpl implements ColorService{
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public List<Color> findAll() {
		return colorRepository.findAll();
	}

	@Override
	public void delete(int id) {
		colorRepository.delete(id);
	}
	@Override
	public void save(Color form) {
		colorRepository.save(form);
	}

	@Override
	public Color findOne(int id) {
		return colorRepository.findOne(id);
	}

	@Override
	public Color findOne(String name) {
		return colorRepository.findByName(name);
	}

	@Override
	public Page<Color> findAll(BasicFilter filter, Pageable pageable) {
		return colorRepository.findAll(new ColorSpecification(filter), pageable);
	}
}
