package com.ebenhabib.employeeneo4jdatarest.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ebenhabib.employeeneo4jdatarest.domain.Employee;
import com.ebenhabib.employeeneo4jdatarest.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employee/", method = RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee data, UriComponentsBuilder ucb) {
		logger.info("Creating a new employee and these collaborators {}", data);

		Employee employee = employeeService.saveEmployee(data);

		HttpHeaders headers = new HttpHeaders();
		URI locationUri = ucb.path("/api/employee/").path(String.valueOf(employee.getEmployeeId())).build().toUri();
		
		headers.setLocation(locationUri);
		
		logger.info("Employee created successfully with info: " + employee);
		
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/employee/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("Fetching all employees");
		
		List<Employee> list = employeeService.findAll();
		if(list.isEmpty()) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

}
