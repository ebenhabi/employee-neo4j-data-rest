package com.ebenhabib.employeeneo4jdatarest.service;

import java.util.List;

import com.ebenhabib.employeeneo4jdatarest.domain.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	Employee findByName(String name);

	List<Employee> findAll();
}

