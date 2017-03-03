package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import ua.entity.Camera;
import ua.entity.Producer;


public interface CameraRepository  extends JpaRepository<Camera, Integer>, JpaSpecificationExecutor<Camera>{
	Camera findByPx(Integer px);


}
