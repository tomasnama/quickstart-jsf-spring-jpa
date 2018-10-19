package com.tomasnama.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tomasnama.SpringConfiguration;
import com.tomasnama.entities.Employee;
import com.tomasnama.services.EmployeesServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AppTest {
	
	@Autowired
	EmployeesServiceImpl employeesService;
	
	@Ignore
	@Test
	public void testGetAllRols() {
		List<Employee> list =employeesService.getEmployees();
		assertTrue(list.size()>0);
		
		
	}



}
