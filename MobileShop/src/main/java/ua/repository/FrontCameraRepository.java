package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.FrontCamera;

public interface FrontCameraRepository extends JpaRepository<FrontCamera, Integer>, JpaSpecificationExecutor<FrontCamera> {
	FrontCamera findByPx(Integer px);
}
