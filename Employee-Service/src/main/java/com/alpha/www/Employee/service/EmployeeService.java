package com.alpha.www.Employee.service;

import com.alpha.www.Employee.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployee(Long id);
}
