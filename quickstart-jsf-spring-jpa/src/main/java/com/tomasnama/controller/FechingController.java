package com.tomasnama.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomasnama.entities.Employee;
import com.tomasnama.services.EmployeesServiceImpl;

@Named("fechingController")
@ViewScoped
public class FechingController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmployeesServiceImpl employeesService;
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	@PostConstruct
    public void init() {
		employees.clear();
		employees.addAll(employeesService.getEmployees());
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
	
	

}
