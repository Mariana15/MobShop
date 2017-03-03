package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.entity.Producer;
import ua.entity.TypeSim;
import ua.repository.CategoryRepository;
import ua.repository.TypeSimRepository;
import ua.service.TypeSimService;
import ua.service.specifications.TypeSimSpecification;

@Service
public class TypeSimServiceImpl implements TypeSimService{
	@Autowired
	private TypeSimRepository typeSimRepository;

	@Override
	public List<TypeSim> findAll() {
		return typeSimRepository.findAll();
	}

	@Override
	public void delete(int id) {
		typeSimRepository.delete(id);
	}
	@Override
	public void save(TypeSim form) {
		typeSimRepository.save(form);
	}

	@Override
	public TypeSim findOne(int id) {
		return typeSimRepository.findOne(id);
	}

	@Override
	public TypeSim findOne(String name) {
		return typeSimRepository.findByName(name);
	}

	@Override
	public Page<TypeSim> findAll(BasicFilter filter, Pageable pageable) {
		return typeSimRepository.findAll(new TypeSimSpecification(filter), pageable);
	}
}
