package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.entity.OS;
import ua.entity.Producer;
import ua.repository.CategoryRepository;
import ua.repository.OSRepository;
import ua.service.OSService;
import ua.service.specifications.OSSpecification;

@Service
public class OSServiceImpl implements OSService{
	@Autowired
	private OSRepository osRepository;

	@Override
	public List<OS> findAll() {
		return osRepository.findAll();
	}

	@Override
	public void delete(int id) {
		osRepository.delete(id);
	}
	@Override
	public void save(OS form) {
		osRepository.save(form);
	}

	@Override
	public OS findOne(int id) {
		return osRepository.findOne(id);
	}

	@Override
	public OS findOne(String name) {
		return osRepository.findByName(name);
	}

	@Override
	public Page<OS> findAll(BasicFilter filter, Pageable pageable) {
		return osRepository.findAll(new OSSpecification(filter), pageable);
	}
}
