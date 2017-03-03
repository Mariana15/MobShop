package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.Producer;
import ua.entity.TypeSim;


public interface TypeSimService {
    List<TypeSim> findAll();
	
	void delete(int id);

	void save(TypeSim form);

	TypeSim findOne(int id);
	TypeSim findOne(String name);
	Page<TypeSim> findAll(BasicFilter filter, Pageable pageable);
}
