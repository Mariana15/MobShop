package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.Producer;

public interface CameraService {
    List<Camera> findAll();
	void delete(int id);
	void save(Camera form);
	Camera findOne(int id);
	Camera findByPx(Integer px);
	Camera findOne(Integer px);
	Page<Camera> findAll(BasicFilter filter, Pageable pageable);


}
