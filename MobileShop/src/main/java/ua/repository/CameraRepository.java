package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Camera;

public interface CameraRepository extends JpaRepository<Camera, Integer>, JpaSpecificationExecutor<Camera> {
	Camera findByPx(Integer px);

}
