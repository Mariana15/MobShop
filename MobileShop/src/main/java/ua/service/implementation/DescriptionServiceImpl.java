package ua.service.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.filter.BasicFilter;
import ua.entity.Description;
import ua.entity.Item;
import ua.repository.DescriptionRepository;
import ua.service.DescriptionService;
import ua.service.specifications.DescriptionSpecification;
@Service
public class DescriptionServiceImpl  implements DescriptionService{

	@Autowired
	private DescriptionRepository descriptionRepository;

	@Override
	@Transactional(readOnly=true)
	public Description findOne(int id) {
		return descriptionRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Description> findAll() {
		return descriptionRepository.findAll();
	}

	@Override
	public void save(Description description) {
		descriptionRepository.save(description);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		Description description = findOne(id);
		Hibernate.initialize(description.getItems());
		for (Item item : description.getItems()) {
			item.setDescription(null);
		}	
		descriptionRepository.delete(id);
		
	}

	@Override
	public Description findByName(String name) {
		return descriptionRepository.findByName(name);
	}

	@Override
	public Page<Description> findAll(Pageable pageable, BasicFilter filter) {
		
		return descriptionRepository.findAll(new DescriptionSpecification(filter), pageable);
	}

}
