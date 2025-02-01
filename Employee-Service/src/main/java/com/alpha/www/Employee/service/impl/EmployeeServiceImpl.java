package com.alpha.www.Employee.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.alpha.www.Employee.dto.EmployeeDto;
import com.alpha.www.Employee.entity.Employee;
import com.alpha.www.Employee.exception.ResourceNotFoundException;
import com.alpha.www.Employee.mapper.EmployeeMapper;
import com.alpha.www.Employee.repository.EmployeeRepository;
import com.alpha.www.Employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
//	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		// dto to entity
//		Employee employee = new Employee(
//				employeeDto.getId(), 
//				employeeDto.getFirstName(), 
//				employeeDto.getLastName(), 
//				employeeDto.getEmail());
		
//		Employee employee = modelMapper.map(employeeDto, Employee.class);
		
		Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
		
		// save to db
		Employee savedEmployee = employeeRepository.save(employee);
		
		// entity to dto
//		EmployeeDto savedEmployeeDto = new EmployeeDto(
//				savedEmployee.getId(), 
//				savedEmployee.getFirstName(), 
//				savedEmployee.getLastName(), 
//				savedEmployee.getEmail());
		
//		EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
		
		EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
		
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		Employee employee = employeeRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
		// entity to dto
//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(), 
//				employee.getFirstName(), 
//				employee.getLastName(), 
//				employee.getEmail());
		
//		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		
		EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
		
		return employeeDto;
	}

}
