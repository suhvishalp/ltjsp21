package com.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.bo.Employee;
import com.demo.dao.EmployeeDAO;
import com.demo.services.EmployeeService;

@Configuration
@ComponentScan
public class MyConfiguration {

//	@Bean
//	public EmployeeDAO createEmployeeDAO() {
//		return new EmployeeDAO();
//	}
//	
//	@Bean
//	public EmployeeService createEmployeeService() {
//		return new EmployeeService();
//	}
//	
//	@Bean
//	public Employee createEmployee() {
//		return new Employee();
//	}
//	
}
