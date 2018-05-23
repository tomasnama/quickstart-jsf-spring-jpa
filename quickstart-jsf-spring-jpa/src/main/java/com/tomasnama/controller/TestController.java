package com.tomasnama.controller;


import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomasnama.services.TestService;


@Named("testController")
@ViewScoped
public class TestController  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String showText = "Hello from controller";
	
	
	@Autowired
	private TestService testService;

	public String getShowText() {
		if (testService!=null) {
			showText =  testService.sayHello();
		}
		return showText;
	}
	
	public void setShowText(String showText) {
		this.showText = showText;
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

}
