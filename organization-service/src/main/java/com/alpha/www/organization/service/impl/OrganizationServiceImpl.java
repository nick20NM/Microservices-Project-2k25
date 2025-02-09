package com.alpha.www.organization.service.impl;

import org.springframework.stereotype.Service;

import com.alpha.www.organization.dto.OrganizationDto;
import com.alpha.www.organization.entity.Organization;
import com.alpha.www.organization.mapper.OrganizationMapper;
import com.alpha.www.organization.repository.OrganizationRepository;
import com.alpha.www.organization.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		// dto to entity
		Organization organization = OrganizationMapper.dtoToEntity(organizationDto);
		
		// save to db
		Organization savedOrganization = organizationRepository.save(organization);
		
		// entity to dto
		return OrganizationMapper.entityToDto(savedOrganization);
	}

}
