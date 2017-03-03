package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.Color;
import ua.entity.Producer;

public interface ColorService {
    List<Color> findAll();
	
	void delete(int id);
	void save(Color form);

	Color findOne(int id);
	Color findOne(String name);
	Page<Color> findAll(BasicFilter filter, Pageable pageable);
}
