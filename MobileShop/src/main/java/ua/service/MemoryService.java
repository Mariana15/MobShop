package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.Memory;
import ua.entity.Producer;

public interface MemoryService {
    List<Memory> findAll();
	
	void delete(int id);

	void save(Memory form);

	Memory findOne(int id);
	Memory findOne(Integer mb);
	Memory findByMb(Integer mb);
	Page<Memory> findAll(BasicFilter filter, Pageable pageable);
}
