package com.alpha.www.Employee.service.impl;

import org.springframework.stereotype.Service;

import com.alpha.www.Employee.dto.EmployeeDto;
import com.alpha.www.Employee.entity.Employee;
import com.alpha.www.Employee.repository.EmployeeRepository;
import com.alpha.www.Employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		// dto to entity
		Employee employee = new Employee(
				employeeDto.getId(), 
				employeeDto.getFirstName(), 
				employeeDto.getLastName(), 
				employeeDto.getEmail());
		
		// save to db
		Employee savedEmployee = employeeRepository.save(employee);
		
		// entity to dto
		EmployeeDto savedEmployeeDto = new EmployeeDto(
				savedEmployee.getId(), 
				savedEmployee.getFirstName(), 
				savedEmployee.getLastName(), 
				savedEmployee.getEmail());
		
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		Employee employee = employeeRepository.findById(id).get();
		
		// entity to dto
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getEmail());
		
		return employeeDto;
	}

}
