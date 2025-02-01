package com.alpha.www.Employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.alpha.www.Employee.dto.EmployeeDto;
import com.alpha.www.Employee.entity.Employee;

@Mapper
public interface EmployeeMapper {
	
	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

	EmployeeDto mapToEmployeeDto(Employee employee);
	
	Employee mapToEmployee(EmployeeDto employeeDto);
}
