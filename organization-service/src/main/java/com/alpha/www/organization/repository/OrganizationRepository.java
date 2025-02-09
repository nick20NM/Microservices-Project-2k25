package com.alpha.www.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.www.organization.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
