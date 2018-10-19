package com.tomasnama.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomasnama.entities.Employee;
import com.tomasnama.model.EmployeeLazyDataModel;
import com.tomasnama.services.EmployeesServiceImpl;

@Named("fechingController")
@ViewScoped
public class FechingController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7916546708367188702L;

	private static final Logger LOG = LogManager.getLogger(PrintController.class);

	private Employee selected = new Employee();
	private Map<String, Object> customfilter = new HashMap<String, Object>();

	@Autowired
	private EmployeesServiceImpl employeesService;

	private EmployeeLazyDataModel employees;

	@PostConstruct
	public void init() {
		employees = new EmployeeLazyDataModel(employeesService, customfilter);
	}

	public void onRowSelect(SelectEvent event) {
		LOG.info(selected.getName());
	}

	public void edit(ActionEvent event) {
		if (selected!=null && selected.getId()>0 ) {
			 PrimeFaces current = PrimeFaces.current();
			 current.executeScript("PF('empDialog').show()");
		 } else {
			 FacesContext context = FacesContext.getCurrentInstance();
	         context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "WARN", "Select employee.") );
			 
		 }


	}

	public void save(ActionEvent event) {
		employeesService.save(selected);
		 PrimeFaces current = PrimeFaces.current();
		 current.executeScript("PF('empDialog').hide()");
	}

	public void cancel(ActionEvent event) {
		 PrimeFaces current = PrimeFaces.current();
		 current.executeScript("PF('empDialog').hide()");
	}

	public void reset(ActionEvent event) {
		customfilter.put("id", null);
		employees = new EmployeeLazyDataModel(employeesService, customfilter);
	}

	public EmployeeLazyDataModel getEmployees() {
		return employees;
	}

	public void setEmployees(EmployeeLazyDataModel employees) {
		this.employees = employees;
	}

	public Employee getSelected() {
		return selected;
	}

	public void setSelected(Employee selected) {
		this.selected = selected;
	}

}
