package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeDAO {
	
	private EntityManager entityManager;
	
	
	public EmployeeDAO() {
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("JPADemo1");
		entityManager =  factory.createEntityManager();
		
	}
	
	public Employee save(Employee emp) {
		entityManager.persist(emp);
		return null;
	}

	public Employee getEmployee(int empId) {
		//
		return null;
	}
	
	public List<Employee> getEmployees(){
		//..
		return null;
	}
	
	//..
	
	//..
}
