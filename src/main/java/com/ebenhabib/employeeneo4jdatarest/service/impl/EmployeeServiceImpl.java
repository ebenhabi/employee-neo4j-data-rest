package com.ebenhabib.employeeneo4jdatarest.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebenhabib.employeeneo4jdatarest.domain.Employee;
import com.ebenhabib.employeeneo4jdatarest.repository.EmployeeRepository;
import com.ebenhabib.employeeneo4jdatarest.service.EmployeeService;

@Service("EmployeeService")
@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		if (employee == null) {
			return null;
		}
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	@Override
	public List<Employee> findAll() {
		Iterable<Employee> iterable = employeeRepository.findAll();
		List<Employee> listEmployees = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
		
		return listEmployees;
	}

}
