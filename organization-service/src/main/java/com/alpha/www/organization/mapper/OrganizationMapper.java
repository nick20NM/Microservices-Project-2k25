package com.alpha.www.organization.mapper;

import com.alpha.www.organization.dto.OrganizationDto;
import com.alpha.www.organization.entity.Organization;

public class OrganizationMapper {

	// dto to entity
	public static Organization dtoToEntity(OrganizationDto organizationDto) {
		return new Organization(
				organizationDto.getId(), 
				organizationDto.getOrganizationName(), 
				organizationDto.getOrganizationDescription(), 
				organizationDto.getOrganizationCode(), 
				organizationDto.getCreatedDate());
	}
	
	// entity to dto
	public static OrganizationDto entityToDto(Organization organization) {
		return new OrganizationDto(
				organization.getId(), 
				organization.getOrganizationName(), 
				organization.getOrganizationDescription(), 
				organization.getOrganizationCode(), 
				organization.getCreatedDate());
	}
}
