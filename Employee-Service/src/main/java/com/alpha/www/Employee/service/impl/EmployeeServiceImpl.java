package com.alpha.www.Employee.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.alpha.www.Employee.dto.APIResponseDto;
import com.alpha.www.Employee.dto.DepartmentDto;
import com.alpha.www.Employee.dto.EmployeeDto;
import com.alpha.www.Employee.entity.Employee;
import com.alpha.www.Employee.exception.ResourceNotFoundException;
import com.alpha.www.Employee.mapper.EmployeeMapper;
import com.alpha.www.Employee.repository.EmployeeRepository;
import com.alpha.www.Employee.service.APIClient;
import com.alpha.www.Employee.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
//	private ModelMapper modelMapper;
	
//	private RestTemplate restTemplate;
	
//	private WebClient webClient;
	
	private APIClient apiClient;
	
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
	public APIResponseDto getEmployee(Long id) {
		Employee employee = employeeRepository
				.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate
//				.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(), DepartmentDto.class);
//		
//		DepartmentDto departmentDto = responseEntity.getBody();
		
//		DepartmentDto departmentDto = webClient
//				.get()
//				.uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
//				.retrieve()
//				.bodyToMono(DepartmentDto.class)
//				.block();
		
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		
		// entity to dto
//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(), 
//				employee.getFirstName(), 
//				employee.getLastName(), 
//				employee.getEmail());
		
//		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		
		EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
		
		APIResponseDto apiResponseDto = new APIResponseDto(employeeDto, departmentDto);
		
		return apiResponseDto;
	}

}
