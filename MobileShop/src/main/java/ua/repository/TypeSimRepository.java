package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Producer;
import ua.entity.TypeSim;

public interface TypeSimRepository extends JpaRepository<TypeSim, Integer>, JpaSpecificationExecutor<TypeSim> {
	TypeSim findByName(String name);
}
