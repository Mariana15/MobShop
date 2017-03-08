package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.NumberOfCores;
import ua.repository.NumberOfCoresRepository;
import ua.service.NumberOfCoresService;
import ua.service.specifications.NumberOfCoresSpecification;

@Service
public class NumberOfCoresServiceImpl implements NumberOfCoresService {
	@Autowired
	private NumberOfCoresRepository numberOfCoresRepository;

	@Override
	public List<NumberOfCores> findAll() {
		return numberOfCoresRepository.findAll();
	}

	@Override
	public void delete(int id) {
		numberOfCoresRepository.delete(id);
	}

	@Override
	public void save(NumberOfCores form) {
		numberOfCoresRepository.save(form);
	}

	@Override
	public NumberOfCores findOne(int id) {
		return numberOfCoresRepository.findOne(id);
	}

	@Override
	public NumberOfCores findOne(Integer cor) {
		// TODO Auto-generated method stub
		return numberOfCoresRepository.findOne(cor);
	}

	@Override
	public NumberOfCores findByCor(Integer cor) {
		// TODO Auto-generated method stub
		return numberOfCoresRepository.findByCor(cor);
	}

	@Override
	public Page<NumberOfCores> findAll(BasicFilter filter, Pageable pageable) {
		return numberOfCoresRepository.findAll(new NumberOfCoresSpecification(filter), pageable);
	}

}
