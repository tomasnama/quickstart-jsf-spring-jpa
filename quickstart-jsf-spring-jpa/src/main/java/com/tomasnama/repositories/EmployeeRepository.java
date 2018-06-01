package com.tomasnama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomasnama.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
