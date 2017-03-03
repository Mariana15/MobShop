package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Description;

public interface DescriptionService {
	
		Description findOne(int id) ;
		List<Description> findAll();
		
		void save(Description description);
		void delete(int id);
		Description findByName(String name);
		Page<Description> findAll(Pageable pageable,BasicFilter filter);
}
