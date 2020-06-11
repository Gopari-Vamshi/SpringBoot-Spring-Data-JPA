package com.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// inject employee dao
	@Autowired
	private EmployeeService employeeService;

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {

		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = employeeService.findEmployee(employeeId);
		
		if(theEmployee==null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
		}
		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);

		employeeService.saveEmployee(theEmployee);

		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
	
		Employee tempEmployee = employeeService.findEmployee(employeeId);
		
		if(tempEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not founud - " + employeeId);
		}
		employeeService.deleteEmployee(employeeId);
		
		return "Deleted employee with id:"+employeeId;
	}
	
}











