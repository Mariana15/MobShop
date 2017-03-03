package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.Producer;
import ua.repository.CameraRepository;
import ua.service.CameraService;
import ua.service.specifications.CameraSpecification;
@Service
public class CameraServiceImpl implements CameraService{

	@Autowired
	private CameraRepository cameraRepository;

	@Override
	public List<Camera> findAll() {
		return cameraRepository.findAll();
	}

	@Override
	public void delete(int id) {
		cameraRepository.delete(id);
	}
	@Override
	public void save(Camera camera) {
		cameraRepository.save(camera);
	}

	@Override
	public Camera findOne(int id) {
		return cameraRepository.findOne(id);
	}



	@Override
	public Camera findOne(Integer px) {
		
		return cameraRepository.findOne(px);
	}

	@Override
	public Camera findByPx(Integer px) {
		// TODO Auto-generated method stub
		return cameraRepository.findByPx(px);
		
	}
	@Override
	public Page<Camera> findAll(BasicFilter filter, Pageable pageable) {
		return cameraRepository.findAll(new CameraSpecification(filter), pageable);
	}

	


}
