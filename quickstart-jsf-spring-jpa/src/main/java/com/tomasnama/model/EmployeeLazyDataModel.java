package com.tomasnama.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.tomasnama.entities.Departament;
import com.tomasnama.entities.Employee;
import com.tomasnama.services.EmployeesServiceImpl;


public class EmployeeLazyDataModel extends LazyDataModel<Employee>{
	
	private EmployeesServiceImpl employeesService;

	public EmployeeLazyDataModel(EmployeesServiceImpl employeesService) {
		this.employeesService = employeesService;
		this.setRowCount(this.employeesService.employeeCount());
	}

	@Override
	public List<Employee> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<Employee> list = employeesService.getEmployeeList(first, pageSize);
		return list;
	}

	public EmployeesServiceImpl getEmployeesService() {
		return employeesService;
	}

	public void setEmployeesService(EmployeesServiceImpl employeesService) {
		this.employeesService = employeesService;
	}
	
	

	
	
}
