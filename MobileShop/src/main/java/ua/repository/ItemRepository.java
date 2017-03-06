package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Item;
import ua.entity.Producer;

public interface ItemRepository extends JpaRepository<Item, Integer>, JpaSpecificationExecutor<Item> {
	@Query("SELECT  i FROM Item i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.camera  LEFT JOIN FETCH i.os  LEFT JOIN FETCH i.color LEFT JOIN FETCH i.diagonal LEFT JOIN FETCH i.fc LEFT JOIN FETCH i.memory LEFT JOIN FETCH i.noc LEFT JOIN FETCH i.nosc LEFT JOIN FETCH i.ts ")
	List<Item> findAll();
	@Query("SELECT  i FROM Item i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.camera  LEFT JOIN FETCH i.os  LEFT JOIN FETCH i.color LEFT JOIN FETCH  i.description LEFT JOIN FETCH i.diagonal LEFT JOIN FETCH i.fc LEFT JOIN FETCH i.memory LEFT JOIN FETCH i.noc LEFT JOIN FETCH i.nosc LEFT JOIN FETCH i.ts  WHERE i.id=:id")
	Item findOne(@Param("id")int id);
	@Query(value="SELECT  i FROM Item i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.camera  LEFT JOIN FETCH i.os  LEFT JOIN FETCH i.color LEFT JOIN FETCH i.diagonal LEFT JOIN FETCH i.fc LEFT JOIN FETCH i.memory LEFT JOIN FETCH i.noc LEFT JOIN FETCH i.nosc LEFT JOIN FETCH i.ts  ",
			countQuery="SELECT count(i.id) FROM Item i")
	Page<Item> findAll(Pageable pageable);
	
	@Query("SELECT DISTINCT i FROM Item i LEFT JOIN FETCH i.users  WHERE i.id=:id " )
	List<Item> findByUserId(@Param("id")int id);
	
}
