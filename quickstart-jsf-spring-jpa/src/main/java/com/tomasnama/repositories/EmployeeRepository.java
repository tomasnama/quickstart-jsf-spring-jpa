package com.tomasnama.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tomasnama.entities.Employee;
import com.tomasnama.repositories.common.BaseRepository;

public interface EmployeeRepository extends BaseRepository<Employee, Long>,  JpaSpecificationExecutor<Employee> {


}
