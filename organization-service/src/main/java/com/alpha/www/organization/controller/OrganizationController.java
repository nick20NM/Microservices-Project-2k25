package com.alpha.www.organization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.organization.dto.OrganizationDto;
import com.alpha.www.organization.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(
		name = "OrganizationController", 
		description = "Exposes REST API's for Organization-Service"
		)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;
	
	@Operation(
			summary = "Save Organization REST API", 
			description = "Used to save organization object in a database"
			)
	@ApiResponse(
			responseCode = "201", 
			description = "HTTP Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Organization REST API", 
			description = "Used to get a single organization object from the database"
			)
	@ApiResponse(
			responseCode = "200", 
			description = "HTTP Status 200 SUCCESS"
			)
	@GetMapping("{code}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
		OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
		return ResponseEntity.ok(organizationDto);
	}
}
