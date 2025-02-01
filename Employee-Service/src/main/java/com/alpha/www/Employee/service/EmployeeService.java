package com.alpha.www.Employee.service;

import com.alpha.www.Employee.dto.APIResponseDto;
import com.alpha.www.Employee.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	APIResponseDto getEmployee(Long id);
}
