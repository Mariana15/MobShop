package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.NumberOfSimCards;
import ua.repository.NumberOfSimCardsRepository;
import ua.service.NumberOfSimCardsService;
import ua.service.specifications.NumberOfSimCardsSpecification;

@Service
public class NumberOfSimCardsServiceImpl implements NumberOfSimCardsService {
	@Autowired
	private NumberOfSimCardsRepository numberOfSimCardsRepository;

	@Override
	public List<NumberOfSimCards> findAll() {
		return numberOfSimCardsRepository.findAll();
	}

	@Override
	public void delete(int id) {
		numberOfSimCardsRepository.delete(id);
	}

	@Override
	public void save(NumberOfSimCards form) {
		numberOfSimCardsRepository.save(form);
	}

	@Override
	public NumberOfSimCards findOne(int id) {
		return numberOfSimCardsRepository.findOne(id);
	}

	@Override
	public NumberOfSimCards findOne(Integer sim) {
		// TODO Auto-generated method stub
		return numberOfSimCardsRepository.findOne(sim);
	}

	@Override
	public NumberOfSimCards findBySim(Integer sim) {
		// TODO Auto-generated method stub
		return numberOfSimCardsRepository.findBySim(sim);
	}

	@Override
	public Page<NumberOfSimCards> findAll(BasicFilter filter, Pageable pageable) {
		return numberOfSimCardsRepository.findAll(new NumberOfSimCardsSpecification(filter), pageable);
	}

}
