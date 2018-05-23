package com.tomasnama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomasnama.entities.Check;

public interface CheckRepository extends JpaRepository<Check, Integer>{

}