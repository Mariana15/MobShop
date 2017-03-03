package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Description;

public interface DescriptionRepository  extends JpaRepository<Description, Integer>,JpaSpecificationExecutor<Description>{
	
	Description findByName(String name);
}
