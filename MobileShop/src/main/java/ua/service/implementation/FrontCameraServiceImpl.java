package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.entity.FrontCamera;
import ua.entity.Producer;
import ua.repository.CategoryRepository;
import ua.repository.FrontCameraRepository;
import ua.service.FrontCameraService;
import ua.service.specifications.FrontCameraSpecification;

@Service
public class FrontCameraServiceImpl implements FrontCameraService{
	@Autowired
	private FrontCameraRepository frontCameraRepository;

	@Override
	public List<FrontCamera> findAll() {
		return frontCameraRepository.findAll();
	}

	@Override
	public void delete(int id) {
		frontCameraRepository.delete(id);
	}
	@Override
	public void save(FrontCamera fc) {
		frontCameraRepository.save(fc);
	}

	@Override
	public FrontCamera findOne(int id) {
		return frontCameraRepository.findOne(id);
	}

	@Override
	public FrontCamera findOne(Integer px) {
	
		return frontCameraRepository.findOne(px);
	}

	@Override
	public FrontCamera findByPx(Integer px) {
		// TODO Auto-generated method stub
		return frontCameraRepository.findByPx(px);
	}

	@Override
	public Page<FrontCamera> findAll(BasicFilter filter, Pageable pageable) {
		return frontCameraRepository.findAll(new FrontCameraSpecification(filter), pageable);
	}

	
}
