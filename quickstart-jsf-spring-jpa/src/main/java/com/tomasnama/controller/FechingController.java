package com.tomasnama.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomasnama.model.EmployeeLazyDataModel;
import com.tomasnama.services.EmployeesServiceImpl;

@Named("fechingController")
@ViewScoped
public class FechingController implements Serializable {
	
	private static final Logger LOG = LogManager.getLogger(PrintController.class);
	
	@Autowired
	private EmployeesServiceImpl employeesService;
	
	private EmployeeLazyDataModel employees;
	
	@PostConstruct
	public void init(){
		 employees = new EmployeeLazyDataModel(employeesService);
	}
	

	public EmployeeLazyDataModel getEmployees() {
		return employees;
	}


	public void setEmployees(EmployeeLazyDataModel employees) {
		this.employees = employees;
	}
	 
	 

}
