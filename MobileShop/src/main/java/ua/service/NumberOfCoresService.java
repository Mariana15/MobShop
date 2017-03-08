package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.NumberOfCores;

public interface NumberOfCoresService {
	List<NumberOfCores> findAll();

	void delete(int id);

	void save(NumberOfCores form);

	NumberOfCores findOne(int id);

	NumberOfCores findOne(Integer cor);

	NumberOfCores findByCor(Integer cor);

	Page<NumberOfCores> findAll(BasicFilter filter, Pageable pageable);
}
