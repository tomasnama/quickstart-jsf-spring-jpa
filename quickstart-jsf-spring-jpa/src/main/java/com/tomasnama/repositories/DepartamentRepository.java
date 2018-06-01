package com.tomasnama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomasnama.entities.Departament;

public interface DepartamentRepository extends JpaRepository<Departament, Long>{
	
	@Query("select d from Departament d where d.name = ?1")
	Departament findByName(String name);
	
}
