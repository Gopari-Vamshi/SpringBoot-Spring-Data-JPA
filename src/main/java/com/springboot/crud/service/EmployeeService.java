package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findEmployee(int theId);

	public void saveEmployee(Employee theEmployee);

	public void deleteEmployee(int theId);
}
