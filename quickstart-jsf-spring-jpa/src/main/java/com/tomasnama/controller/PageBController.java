package com.tomasnama.controller;

import java.io.Serializable;

import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("pageBController")
@ViewScoped
public class PageBController  implements Serializable {
	
	@ManagedProperty(value = "#{param.param1}")
    private String param1;

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}
	

}
