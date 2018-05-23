package com.tomasnama.services;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
	
	public String sayHello() {
		return "Hello from spring service";
	}

}
