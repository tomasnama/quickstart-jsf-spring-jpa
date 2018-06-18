package com.tomasnama.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tomasnama.entities.Departament;
import com.tomasnama.entities.Employee;
import com.tomasnama.model.EmployeeLazyDataModel;
import com.tomasnama.repositories.DepartamentRepository;
import com.tomasnama.repositories.EmployeeRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	private static final Logger LOG = LogManager.getLogger(EmployeesServiceImpl.class);

	@Autowired
	private DepartamentRepository departamentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void init() {
		departamentRepository.save(new Departament("Informatica"));
		departamentRepository.save(new Departament("Contabilidad"));
		departamentRepository.save(new Departament("RRHH"));
		departamentRepository.save(new Departament("Direccion"));
		Departament informatica = departamentRepository.findByName("Informatica");
		Departament contabilidad = departamentRepository.findByName("Contabilidad");
		Departament rrhh = departamentRepository.findByName("RRHH");
		Departament direccion = departamentRepository.findByName("Direccion");

		for (int i = 0; i < 100; i++) {
			employeeRepository.save(new Employee("Pepe Luis", "Manager", 1000, direccion));
			employeeRepository.save(new Employee("Luis Antonio", "Manager", 1000, contabilidad));
			employeeRepository.save(new Employee("Tomás Navarro", "Developer", 10000, informatica));
			employeeRepository.save(new Employee("Carlos Jesus", "Manager", 1000, rrhh));
			employeeRepository.save(new Employee("Antonia la piedra", "CEO", 1000, direccion));
		}

	}

	public List<Employee> getEmployeeList(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		Page<Employee>  listPage = employeeRepository.findAll(pageable);
		return listPage.getContent();
	}
	
	public int employeeCount() {
		return (int) employeeRepository.count();
	}

	public List<Departament> getDepartaments() {
		return departamentRepository.findAll();
	}

	public Departament getDepartament(long id) {
		return departamentRepository.findOne(id);
	}

	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

}
