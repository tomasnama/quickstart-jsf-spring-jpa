package com.tomasnama.exemple.flow;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;

import javax.inject.Named;

@Named
@FlowScoped("flowA")
public class FlowBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int itemCount;
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getName() {
		return "BasicFlow";
	}

	public String getReturnValue() {
		return " /index";
	}

}
