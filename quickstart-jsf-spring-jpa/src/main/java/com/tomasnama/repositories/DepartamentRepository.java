package com.tomasnama.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tomasnama.entities.Departament;
import com.tomasnama.repositories.common.BaseRepository;

public interface DepartamentRepository extends BaseRepository<Departament, Long>, JpaSpecificationExecutor<Departament>{
	
	@Query("select d from Departament d where d.name = ?1")
	Departament findByName(String name);
	
}
