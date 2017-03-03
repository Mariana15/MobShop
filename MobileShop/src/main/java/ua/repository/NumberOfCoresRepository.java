package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.NumberOfCores;
import ua.entity.Producer;

public interface NumberOfCoresRepository extends JpaRepository<NumberOfCores, Integer> , JpaSpecificationExecutor<NumberOfCores>{
	NumberOfCores findByCor(Integer cor);
}
