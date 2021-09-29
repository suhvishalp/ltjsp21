package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Employee;
import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.FieldErrorMessage;
import com.demo.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	public EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable("empId") int id){
		return empService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	public Employee saveEmp(@Valid @RequestBody Employee emp) {
		
		return empService.save(emp);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<FieldErrorMessage> handleValidationExpcetion(MethodArgumentNotValidException ex) {
		
		List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
		
		List<FieldErrorMessage> list = new ArrayList<>();
		
		for(FieldError error : errorList ) {
			FieldErrorMessage frm = new FieldErrorMessage(error.getField(), error.getDefaultMessage());
			list.add(frm);
		}
		
		
		return list;
	}
	
//	@PostMapping("/employees")
//	@ResponseStatus(code = HttpStatus.OK)
//	public Employee saveEmp(@RequestBody Employee emp) throws Exception {
//		
//		if(emp.getName()!=null)
//				return empService.save(emp);
//		
//		throw new Exception("emp name is not valid");
//	}
	
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> MyExceptionHandler(Exception ex) {
//		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//	}
	
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ErrorMessage MyExceptionHandler(Exception ex) {
//		return new ErrorMessage(ex.getMessage(), "400");
//	}
	
	
	@PutMapping("/employees/{empId}")
	public Employee update(@PathVariable("empId") int id, @RequestBody Employee emp) {
		return empService.update(id, emp);
	}
	
	@DeleteMapping("/employees/{empId}")
	public Employee deleteEmp(@PathVariable("empId")int id) {
		return empService.remove(id);
	}
}
