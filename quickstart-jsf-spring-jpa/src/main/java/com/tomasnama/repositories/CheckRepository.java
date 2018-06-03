package com.tomasnama.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomasnama.entities.Check;

public interface CheckRepository extends JpaRepository<Check, Integer> {

	@Query("Select c from Check c where c.name like %?1%")
	List<Check> findByName(String name);

}