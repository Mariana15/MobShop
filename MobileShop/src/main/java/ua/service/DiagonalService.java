package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Diagonal;

public interface DiagonalService {
	List<Diagonal> findAll();

	void delete(int id);

	void save(Diagonal form);

	Diagonal findOne(int id);

	// Diagonal findOne(String name);
	Diagonal findByD(Integer d);

	Diagonal findOne(Integer d);

	Page<Diagonal> findAll(BasicFilter filter, Pageable pageable);
}
