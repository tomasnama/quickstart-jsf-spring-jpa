package com.tomasnama.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	public Employee() {
		super();
	}

	public Employee(String name, String designation, int salary, Departament department) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.department = department;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "SALARY")
	private int salary;

	@ManyToOne
	@JoinColumn(name = "DPT_ID")
	private Departament department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
		this.department = department;
	}
	
}
