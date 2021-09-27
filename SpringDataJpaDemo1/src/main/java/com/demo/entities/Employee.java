package com.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee_table")
@NamedQuery(name = "getAllEmpsByCity", query = "SELECT e FROM Employee e where e.city=?1")
public class Employee {
	
	@Id
	private int id;
	
	@Column(name = "ename", length = 50)
	private String name;
	private String city;
	
	
	private double salary;
	
	@Temporal(TemporalType.DATE)
	private Date doj;
	
	private boolean isActive;
	
	public Employee() {
		super();
	}
	
	
	

	public Employee(String name) {
		super();
		this.name = name;
	}




	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public Date getDoj() {
		return doj;
	}



	public void setDoj(Date doj) {
		this.doj = doj;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\n\t Employee [id=" + id + ", name=" + name + ", city=" + city + ", salary=" + salary + "]";
	} 
	
	
}
