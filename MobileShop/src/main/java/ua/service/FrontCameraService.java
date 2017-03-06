package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.Camera;
import ua.entity.FrontCamera;
import ua.entity.Producer;

public interface FrontCameraService {
    List<FrontCamera> findAll();
	void delete(int id);
	void save(FrontCamera form);
	FrontCamera findOne(int id);
	FrontCamera findOne(Integer px);
	FrontCamera findByPx(Integer px);
	Page<FrontCamera> findAll(BasicFilter filter, Pageable pageable);
}
