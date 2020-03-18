package com.ebenhabib.employeeneo4jdatarest.translator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ebenhabib.employeeneo4jdatarest.domain.Employee;
import com.ebenhabib.employeeneo4jdatarest.dto.EmployeeDto;


public class EmployeeDtoTranslator {

	public EmployeeDto convertEntityToDto(Employee employee) {
		EmployeeDto result = new EmployeeDto();
		if (employee == null) {
			return result;
		}

		result.setEmployeeId(employee.getEmployeeId());
		result.setName(employee.getName());
		result.setCollaborators(getCollaborators(employee.getCollaborators()));
		result.setSupervisors(getSupervisors(employee.getSupervisors()));
		
		return result;
	}
	
	private Set<EmployeeDto> getCollaborators(Set<Employee> collaborators) {
		Set<EmployeeDto> result = new HashSet<>();
		if(collaborators != null && !collaborators.isEmpty()) {
			for(Employee entity: collaborators) {
				EmployeeDto dto = new EmployeeDto();
				dto.setEmployeeId(entity.getEmployeeId());
				dto.setName(entity.getName());
				dto.setCollaborators(getCollaborators(entity.getCollaborators()));
				dto.setSupervisors(getSupervisors(entity.getSupervisors()));
				
				result.add(dto);
			}
		}
		
		return result;
	}
	
	private Set<EmployeeDto> getSupervisors(Set<Employee> supervisors) {
		Set<EmployeeDto> result = new HashSet<>();
		if(supervisors != null && !supervisors.isEmpty()) {
			for(Employee entity: supervisors) {
				EmployeeDto dto = new EmployeeDto();
				dto.setEmployeeId(entity.getEmployeeId());
				dto.setName(entity.getName());
				dto.setCollaborators(getCollaborators(entity.getCollaborators()));
				dto.setSupervisors(getSupervisors(entity.getSupervisors()));
				
				result.add(dto);
			}
		}
		
		return result;
	}
	
	public Employee convertDtoToEntity(EmployeeDto employeeDto) {
		Employee result = new Employee();
		if(employeeDto == null) {
			return result;
		}
		
		result.setName(employeeDto.getName());
		result.setCollaborators(getEntityCollaborators(employeeDto.getCollaborators()));
		result.setSupervisors(getEntitySupervisors(employeeDto.getSupervisors()));
		
		return result;
	}
	
	private Set<Employee> getEntityCollaborators(Set<EmployeeDto> collaborators) {
		Set<Employee> result = new HashSet<>();
		if(collaborators != null && !collaborators.isEmpty()) {
			for(EmployeeDto dto: collaborators) {
				Employee entity = new Employee();
				entity.setName(dto.getName());
				entity.setCollaborators(getEntityCollaborators(dto.getCollaborators()));
				entity.setSupervisors(getEntitySupervisors(dto.getSupervisors()));
				
				result.add(entity);
			}
		}
		
		return result;
	}
	
	private Set<Employee> getEntitySupervisors(Set<EmployeeDto> supervisors) {
		Set<Employee> result = new HashSet<>();
		if(supervisors != null && !supervisors.isEmpty()) {
			for(EmployeeDto dto: supervisors) {
				Employee entity = new Employee();
				entity.setName(dto.getName());
				entity.setCollaborators(getEntityCollaborators(dto.getCollaborators()));
				entity.setSupervisors(getEntitySupervisors(dto.getSupervisors()));
				
				result.add(entity);
			}
		}
		
		return result;
	}
	
	public List<EmployeeDto> convertToListDto(List<Employee> employees){
		List<EmployeeDto> result = new ArrayList<EmployeeDto>();
		
		if(employees != null && !employees.isEmpty()) {
			for(Employee employee: employees) {
				EmployeeDto employeeDto = convertEntityToDto(employee);
				result.add(employeeDto);
			}
		}
		
		return result;
	}
}
