package com.tomasnama.controller;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomasnama.entities.Check;
import com.tomasnama.services.TestServiceImpl;


@Named("testController")
@ViewScoped
public class TestController  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String showText = "Hello from controller";
	@Autowired
	private TestServiceImpl testService;
	private List<Check> checks;
	private String name;
	
	
	@PostConstruct
    public void init() {
		checks = testService.getChecks();
	}
	
	public void filter(ActionEvent actionEvent) {
		 System.out.println(name);
    }
	
	public String getShowText() {
		if (testService!=null) {
			showText =  testService.sayHello();
		}
		return showText;
	}
	
	public void setShowText(String showText) {
		this.showText = showText;
	}


	public List<Check> getChecks() {
		return checks;
	}

	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
