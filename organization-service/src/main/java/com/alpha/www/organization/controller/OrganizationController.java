package com.alpha.www.organization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.www.organization.dto.OrganizationDto;
import com.alpha.www.organization.service.OrganizationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

	private OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
	}
}
