package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Memory;

public interface MemoryRepository extends JpaRepository<Memory, Integer>, JpaSpecificationExecutor<Memory> {
	Memory findByMb(Integer mb);
}
