package com.tomasnama.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomasnama.entities.Departament;
import com.tomasnama.entities.Employee;
import com.tomasnama.services.EmployeesServiceImpl;

@Named("masterdetailController")
@ViewScoped
public class MasterdetailController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private EmployeesServiceImpl employeesService;
	
	private List<Departament> departaments = new ArrayList<Departament>();
	private List<Employee> employees = new ArrayList<Employee>();
	private Departament currentDept = new Departament();

	
	@PostConstruct
    public void init() {
		departaments.clear();
		departaments.addAll(employeesService.getDepartaments());
		employees.clear();
		employees.addAll(employeesService.getDepartaments().get(0).getEmployees());
		currentDept = employeesService.getDepartaments().get(0);
	}
	
	 public void onRowSelect(SelectEvent event) {
		 currentDept = (Departament) event.getObject();
		 employees.clear();
		 employees.addAll(employeesService.getDepartament(currentDept.getId()).getEmployees());
	 }
	
	public List<Departament> getDepartaments() {
		return departaments;
	}

	public void setDepartaments(List<Departament> departaments) {
		this.departaments = departaments;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Departament getCurrentDept() {
		return currentDept;
	}

	public void setCurrentDept(Departament currentDept) {
		this.currentDept = currentDept;
	}
	
	
	

}
