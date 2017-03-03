package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Color;
import ua.entity.Producer;


public interface ColorRepository extends JpaRepository<Color, Integer>, JpaSpecificationExecutor<Color>{
	Color findByName(String name);
}
