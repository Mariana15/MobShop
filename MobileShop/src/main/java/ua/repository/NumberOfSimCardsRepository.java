package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.NumberOfSimCards;

public interface NumberOfSimCardsRepository extends JpaRepository<NumberOfSimCards, Integer>, JpaSpecificationExecutor<NumberOfSimCards> {
	NumberOfSimCards findBySim(Integer sim);
}
