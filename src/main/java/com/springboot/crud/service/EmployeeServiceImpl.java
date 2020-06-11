package com.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.crud.dao.EmployeeRepository;
import com.springboot.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	public Employee findEmployee(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;
		if (result.isPresent()) {

			theEmployee = result.get();
		}
		
		return theEmployee;
	}

	public void saveEmployee(Employee theEmployee) {

		employeeRepository.save(theEmployee);
	}

	public void deleteEmployee(int theId) {

		employeeRepository.deleteById(theId);
	}

}
