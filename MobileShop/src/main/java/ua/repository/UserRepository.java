package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.items i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.camera  LEFT JOIN FETCH i.os  LEFT JOIN FETCH i.color LEFT JOIN FETCH  i.description LEFT JOIN FETCH i.diagonal LEFT JOIN FETCH i.fc LEFT JOIN FETCH i.memory LEFT JOIN FETCH i.noc LEFT JOIN FETCH i.nosc LEFT JOIN FETCH i.ts  WHERE u.username= ?1")

	User findByUsername(String username);

	@Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.items i LEFT JOIN FETCH i.category LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.camera  LEFT JOIN FETCH i.os  LEFT JOIN FETCH i.color LEFT JOIN FETCH  i.description LEFT JOIN FETCH i.diagonal LEFT JOIN FETCH i.fc LEFT JOIN FETCH i.memory LEFT JOIN FETCH i.noc LEFT JOIN FETCH i.nosc LEFT JOIN FETCH i.ts  ")

	List<User> findAll();
}
