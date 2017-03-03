package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Diagonal;
import ua.entity.Producer;


public interface DiagonalRepository extends JpaRepository<Diagonal, Integer>, JpaSpecificationExecutor<Diagonal>{
	Diagonal findByD(Integer d);

	Diagonal findOne(Integer d);

}
