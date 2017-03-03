package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.entity.Memory;
import ua.entity.Producer;
import ua.repository.CategoryRepository;
import ua.repository.MemoryRepository;
import ua.service.MemoryService;
import ua.service.specifications.MemorySpecification;

@Service
public class MemoryServiceImpl implements MemoryService{
	@Autowired
	private MemoryRepository memoryRepository;

	@Override
	public List<Memory> findAll() {
		return memoryRepository.findAll();
	}

	@Override
	public void delete(int id) {
		memoryRepository.delete(id);
	}
	@Override
	public void save(Memory form) {
		memoryRepository.save(form);
	}

	@Override
	public Memory findOne(int id) {
		return memoryRepository.findOne(id);
	}

	@Override
	public Memory findOne(Integer mb) {
		// TODO Auto-generated method stub
		return memoryRepository.findOne(mb);
	}

	@Override
	public Memory findByMb(Integer mb) {
		// TODO Auto-generated method stub
		return memoryRepository.findByMb(mb);
	}

	@Override
	public Page<Memory> findAll(BasicFilter filter, Pageable pageable) {
		return memoryRepository.findAll(new MemorySpecification(filter), pageable);
	}

	
}
