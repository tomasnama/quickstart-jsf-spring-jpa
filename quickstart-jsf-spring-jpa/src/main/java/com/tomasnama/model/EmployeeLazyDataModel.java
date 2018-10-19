package com.tomasnama.model;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.SortOrder;

import com.tomasnama.entities.Employee;
import com.tomasnama.services.EmployeesServiceImpl;


public class EmployeeLazyDataModel extends BaseLazyDataModel<Employee>{
	
	private static final Logger LOG = LogManager.getLogger(EmployeeLazyDataModel.class);
	
	private EmployeesServiceImpl employeesService;
	List<Employee> datasource;

	public EmployeeLazyDataModel(EmployeesServiceImpl employeesService,  Map<String, Object> filter) {
		this.employeesService = employeesService;
		this.customfilter = filter;
	}
	
	@Override
	public Employee getRowData(String rowKey) {
		Long longRowKey = new Long(rowKey);
		return employeesService.findEmployee(longRowKey);
	}
	
	@Override
    public Object getRowKey(Employee event) {
        return event.getId();
    }


	@Override
	public List<Employee> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filter) {
		int page = first / pageSize;
		if (!filter.isEmpty()) {
			this.customfilter.putAll(filter);
		}
		this.setRowCount((int)this.employeesService.employeeCount(this.customfilter));
		datasource = employeesService.getEmployeeList(page, pageSize, this.getSort(sortField, sortOrder), this.customfilter);
		return datasource;

	}
	
	
}
