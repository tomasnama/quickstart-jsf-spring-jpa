package com.tomasnama.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tomasnama.entities.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

}
