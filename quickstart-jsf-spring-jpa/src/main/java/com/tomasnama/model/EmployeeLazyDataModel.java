package com.tomasnama.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Component;

import com.tomasnama.entities.Employee;


@Component
public class EmployeeLazyDataModel extends LazyDataModel<Employee>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Autowired
	//private EmployeesServiceImpl employeesService;

	public EmployeeLazyDataModel() {
		//employeesService.employeeCount();
		this.setRowCount(500);
	}

	@Override
	public List<Employee> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		List<Employee> list = null; //employeesService.getEmployeeList(first, pageSize);
		return list;
	}

	
	
}
