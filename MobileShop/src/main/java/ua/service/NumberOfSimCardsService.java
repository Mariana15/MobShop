package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.NumberOfSimCards;
import ua.entity.Producer;

public interface NumberOfSimCardsService {
    List<NumberOfSimCards> findAll();
	
	void delete(int id);

	void save(NumberOfSimCards form);

	NumberOfSimCards findOne(int id);
	NumberOfSimCards findOne(Integer sim);
	NumberOfSimCards findBySim(Integer sim);
	Page<NumberOfSimCards> findAll(BasicFilter filter, Pageable pageable);
}
