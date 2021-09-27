package com.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.demo.entities.Employee;
import com.demo.repositories.EmployeeRepository;

@SpringBootTest
class SpringDataJpaDemo1ApplicationTests {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Test
	void contextLoads() {
	}

	
//	@Test
//	public void testCreateEmployee() {
//		Employee emp = new Employee();
//		emp.setId(2);
//		emp.setName("Amit");
//		emp.setCity("Hyderabad");
//		emp.setSalary(2000.00);
//		
//		empRepo.save(emp);
//		
//	}
	
//	@Test
//	public void testFindEmployee() {
//		
//		Optional<Employee> optEmp = empRepo.findById(1);
//		
//		if(optEmp.isPresent()) {
//			Employee e = optEmp.get();
//			System.out.println(e);
//		}
//		
//	}
//	
//	@Test
//	public void testDeleteEmployee() {
//		empRepo.deleteById(1);
//	}
	
	
//	@Test
//	public void testUpdateEmployee() {
//		Optional<Employee> optEmp = empRepo.findById(2);
//		
//		if(optEmp.isPresent()) {
//			Employee emp = optEmp.get();
//			emp.setSalary(3000.00);
//			empRepo.save(emp);
//		}
//	}
	
//	@Test
//	public void testCreateEmployees() {
//		Employee emp = new Employee();
//		emp.setId(1);
//		emp.setName("vishal");
//		emp.setCity("Hyd");
//		emp.setDoj(new Date(2021, 1, 1));
//		emp.setActive(true);
//		
//		empRepo.save(emp);
//	}
//	
	
//	@Test
//	public void testExample() {
//		
//		Employee employee = new Employee("vishal");
//		
//		Example<Employee> example = Example.of(employee);
//		
//		Optional<Employee> optEmp = empRepo.findOne(example);
//		
//		if(optEmp.isPresent()) {
//			Employee e = optEmp.get();
//			System.out.println(e);
//		}
//	}
	
//	@Test
//	public void testCustomQueryMethod() {
//	   List<Employee> list =	empRepo.getAllEmployees(2500.00);
//	   System.out.println(list);
//	}
	
//	@Test
//	public void testNamedQuery() {
//		List<Employee> list = empRepo.getAllEmpsByCity("Hyd");
//		System.out.println(list);
//	}
//	
	
	
	@Test
	public void testQueryGenerationMethod() {
		List<Employee> list =  empRepo.findAllByCityAndSalaryGreaterThan("Hyd",2500.00);
		System.out.println(list);
	}
	
//	@Test
//	public void testSorting() {
//		Sort sort = Sort.by("salary");
//		Iterable<Employee> itrEmps =  empRepo.findAll(sort);
//		
//		for(Employee emp : itrEmps) {
//			System.out.println(emp);
//		}
//	}
	
	
}
