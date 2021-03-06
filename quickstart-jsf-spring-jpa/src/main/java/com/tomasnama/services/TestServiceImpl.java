package com.tomasnama.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasnama.entities.Check;
import com.tomasnama.repositories.CheckRepository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private CheckRepository checkRepository;
	private List<Check> checks = new ArrayList<Check>();
	
	public List<Check> getChecks(String name) {
		return checkRepository.findByName(name);
	}
	
	
	@PostConstruct
	public void init() {
		for (int i = 1; i <= 10; i = i + 1) {
			Check check = new Check();
			check.setName("example "+i);
			check.setUrl("http://www.example.com");
			checkRepository.save(check);
			checks.add(check);
		}
		
	}

	public String sayHello() {
		return "Hello from spring service";
	}

	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}

	public List<Check> getChecks() {
		return checks;
	}
	
	

}
