package com.tomasnama.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomasnama.entities.Check;
import com.tomasnama.repositories.CheckRepository;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private CheckRepository checkRepository;
	
	@PostConstruct
	public void init() {
		Check check = new Check();
		check.setName("example");
		check.setUrl("http://www.example.com");
		checkRepository.save(check);
	}
	
	public String sayHello() {
		return "Hello from spring service";
	}

}
