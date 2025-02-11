package com.alpha.www.Employee.mapper;

import com.alpha.www.Employee.dto.EmployeeDto;
import com.alpha.www.Employee.entity.Employee;

public class EmployeeMapper2 {

	// dto to entity
	public static Employee dtoToEntity(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(), 
				employeeDto.getFirstName(), 
				employeeDto.getLastName(), 
				employeeDto.getEmail(), 
				employeeDto.getDepartmentCode(), 
				employeeDto.getOrganizationCode());
	}
	
	// entity to dto
	public static EmployeeDto entityToDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getEmail(), 
				employee.getDepartmentCode(), 
				employee.getOrganizationCode());
	}
}
