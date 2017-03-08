package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.OS;

public interface OSService {
	List<OS> findAll();

	void delete(int id);

	void save(OS form);

	OS findOne(int id);

	OS findOne(String name);

	Page<OS> findAll(BasicFilter filter, Pageable pageable);
}
