package com.ebenhabib.employeeneo4jdatarest.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity(label = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private Long employeeId;
	
	@Property(name = "name")
	private String name;
	
	/**
	 * The relationship is kept undirected to ensure that if 
	 * an Employee John WORKS_WITH another Employee Kate, 
	 * then Employee Kate also WORKS_WITH Employee John
	 */
	@Relationship(type = "WORKS_WITH", direction = Relationship.UNDIRECTED)
	private Set<Employee> collaborators;
	
	@Relationship(type = "IS_SUPERVISOR_OF", direction = Relationship.DIRECTION)
	private Set<Employee> supervisors;
	
	public Employee() {
		super();
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public Long getEmployeeId() {
		return employeeId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Employee> getCollaborators() {
		return collaborators;
	}
	
	public void setCollaborators(Set<Employee> collaborators) {
		this.collaborators = collaborators;
	}

	public Set<Employee> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(Set<Employee> supervisors) {
		this.supervisors = supervisors;
	}

	public void addCollaborator(Employee employee) {
		if(collaborators == null) {
			collaborators = new HashSet<>();
		}
		
		collaborators.add(employee);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeId = ");
		builder.append(employeeId);
		builder.append(", name = ");
		builder.append(name);
		builder.append(", collaborators=");
		builder.append(collaborators);
		builder.append(", supervisors=");
		builder.append(supervisors);
		builder.append("]");
		
		return  String.valueOf(builder);
	}
	
}
