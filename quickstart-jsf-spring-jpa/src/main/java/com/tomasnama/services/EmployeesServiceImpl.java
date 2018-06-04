package com.tomasnama.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasnama.entities.Departament;
import com.tomasnama.entities.Employee;
import com.tomasnama.repositories.DepartamentRepository;
import com.tomasnama.repositories.EmployeeRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
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
		departamentRepository.findByName("Informatica");
		employeeRepository.save(new Employee("Pepe Luis", "Manager", 1000, direccion));
		employeeRepository.save(new Employee("Luis Antonio", "Manager", 1000, contabilidad));
		employeeRepository.save(new Employee("Tomás Navarro", "Developer", 10000, informatica));
		employeeRepository.save(new Employee("Carlos Jesus", "Manager", 1000, rrhh));
		employeeRepository.save(new Employee("Antonia la piedra", "CEO", 1000, direccion));
	}
	
	public List<Departament> getDepartaments() {
		List<Departament> departaments = new ArrayList<Departament>();
		departaments.addAll(departamentRepository.findAll());
		return departaments;
	}
	
	public Departament getDepartament(long id) {
		return departamentRepository.findOne(id);
	}
	
}
