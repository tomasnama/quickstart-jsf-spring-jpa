package com.tomasnama.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named("loginController")
@SessionScoped
public class LoginController implements Serializable{
	private static final Logger LOG = LogManager.getLogger(TestController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	
	
	public void login(ActionEvent actionEven) {
		LOG.info(username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
