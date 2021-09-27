package com.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import com.demo.entities.Customer;
import com.demo.entities.Employee;
import com.demo.entities.Genre;
import com.demo.entities.Movie;
import com.demo.repositories.CustomerRepository;
import com.demo.repositories.EmployeeRepository;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.MovieRepository;

@SpringBootTest
class SpringDataJpaDemo1ApplicationTests {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private CustomerRepository custRepo;

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
//	
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
//		emp.setUsername("vishal");
//		emp.setPassword("vis123");
//		emp.setCity("Hyd");
//		emp.setDoj(new Date(2021, 1, 1));
//		emp.setActive(true);
//		
//		empRepo.save(emp);
//	}
//	
//	@Test
//	public void testCreateCustomer() {
//		
//		Customer cust = new Customer();
//		cust.setAddress("Mumbai");
//		cust.setCustId(2);
//		cust.setId(2);
//		cust.setPassword("somepass");
//		cust.setUsername("anil");
//		
//		
//		custRepo.save(cust);
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
	
	
//	@Test
//	public void testQueryGenerationMethod() {
//		List<Employee> list =  empRepo.findAllByCityAndSalaryGreaterThan("Hyd",2500.00);
//		System.out.println(list);
//	}
	
//	@Test
//	public void testSorting() {
//		Sort sort = Sort.by("salary");
//		Iterable<Employee> itrEmps =  empRepo.findAll(sort);
//		
//		for(Employee emp : itrEmps) {
//			System.out.println(emp);
//		}
//	}
	
	
	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	MovieRepository movieRepo;
	
//	@Test
//	public void testGenreCreate() {
//		
//		Genre genre = new Genre();
//		genre.setName("Action");
//		
//		Movie m1 = new Movie();
//		m1.setTitle("movie1");
//		m1.setDailyRentalRate(1);
//		m1.setNumberInStock(3);
//		m1.setGenre(genre);
//		
//		Movie m2  = new Movie();
//		m2.setTitle("movie1");
//		m2.setDailyRentalRate(1);
//		m2.setNumberInStock(3);
//		m2.setGenre(genre);
//		
//		
//		genre.addMovie(m1);
//		genre.addMovie(m2);
//		
//		genreRepo.save(genre);
//	}
	
	@Test
	@Transactional
	public void testFetchGenre() {
		Optional<Genre> optGenre =  genreRepo.findById(1);
		if(optGenre.isPresent()) {
			Genre genre = optGenre.get();
			System.out.println("\n\n\t Genre name : " + genre.getName());
			
			List<Movie> list = genre.getMovies();
			System.out.println("\n\n\t Movie count : " + list.size());
		}
	}
	
	@Test
	public void testMovieCreate() {
		
	}
	
	
}
