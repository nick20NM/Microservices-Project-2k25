package com.alpha.www.Employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.Employee.dto.APIResponseDto;
import com.alpha.www.Employee.dto.EmployeeDto;
import com.alpha.www.Employee.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "EmployeeController", 
		description = "Exposes REST API's for Employee-Service"
		)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Operation(
			summary = "Save Employee REST API", 
			description = "Used to save employee object into database"
			)
	@ApiResponse(
			responseCode = "201", 
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Employee REST API", 
			description = "Used to get an employee object from the database"
			)
	@ApiResponse(
			responseCode = "200", 
			description = "HTTP Status 200 OK"
			)
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id){
		APIResponseDto apiResponseDto = employeeService.getEmployee(id);
		return ResponseEntity.ok(apiResponseDto);
	}
}
