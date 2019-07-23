package com.tomasnama.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.tomasnama.entities.Check;
import com.tomasnama.repositories.common.BaseRepository;

public interface CheckRepository extends BaseRepository <Check, Integer>, JpaSpecificationExecutor<Check> {

	@Query("Select c from Check c where c.name like %?1%")
	List<Check> findByName(String name);

}