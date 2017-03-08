package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Diagonal;
import ua.repository.DiagonalRepository;
import ua.service.DiagonalService;
import ua.service.specifications.DiagonalSpecification;

@Service
public class DiagonalServiceImpl implements DiagonalService {
	@Autowired
	private DiagonalRepository diagonalRepository;

	@Override
	public List<Diagonal> findAll() {
		return diagonalRepository.findAll();
	}

	@Override
	public void delete(int id) {
		diagonalRepository.delete(id);
	}

	@Override
	public void save(Diagonal form) {
		diagonalRepository.save(form);
	}

	@Override
	public Diagonal findOne(int id) {
		return diagonalRepository.findOne(id);
	}

	@Override
	public Diagonal findByD(Integer d) {
		// TODO Auto-generated method stub
		return diagonalRepository.findByD(d);
	}

	@Override
	public Diagonal findOne(Integer d) {

		return diagonalRepository.findOne(d);
	}

	@Override
	public Page<Diagonal> findAll(BasicFilter filter, Pageable pageable) {
		return diagonalRepository.findAll(new DiagonalSpecification(filter), pageable);
	}

}
