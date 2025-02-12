package com.alpha.www.Department.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.Department.dto.DepartmentDto;
import com.alpha.www.Department.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "DepartmentController", 
		description = "Exposes REST API's for Department-Service"
		)
@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;
	
	@Operation(
			summary = "Save Department REST API", 
			description = "Used to save department object in a database"
			)
	@ApiResponse(
			responseCode = "201", 
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Department REST API", 
			description = "Used to get a department object from the database"
			)
	@ApiResponse(
			responseCode = "200", 
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return ResponseEntity.ok(departmentDto);
	}
}
