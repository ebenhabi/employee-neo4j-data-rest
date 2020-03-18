package com.ebenhabib.employeeneo4jdatarest.dto;

import java.io.Serializable;
import java.util.Set;

public class EmployeeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3398025512304070048L;
	
	private Long employeeId;
	private String name;
	private Set<EmployeeDto> collaborators;
	private Set<EmployeeDto> supervisors;
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeDto> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Set<EmployeeDto> collaborators) {
		this.collaborators = collaborators;
	}

	public Set<EmployeeDto> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(Set<EmployeeDto> supervisors) {
		this.supervisors = supervisors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDto [employeeId=");
		builder.append(employeeId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", collaborators=");
		builder.append(collaborators);
		builder.append(", supervisors=");
		builder.append(supervisors);
		builder.append("]");
		
		return  String.valueOf(builder);
	}
	
	
}
