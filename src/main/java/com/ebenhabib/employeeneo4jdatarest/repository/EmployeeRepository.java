package com.ebenhabib.employeeneo4jdatarest.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.ebenhabib.employeeneo4jdatarest.domain.Employee;

public interface EmployeeRepository extends Neo4jRepository<Employee, Integer> {

	Employee findByName(String name);
}
