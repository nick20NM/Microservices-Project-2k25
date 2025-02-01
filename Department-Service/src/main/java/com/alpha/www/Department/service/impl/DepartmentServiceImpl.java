package com.alpha.www.Department.service.impl;

import org.springframework.stereotype.Service;

import com.alpha.www.Department.dto.DepartmentDto;
import com.alpha.www.Department.entity.Department;
import com.alpha.www.Department.repository.DepartmentRepository;
import com.alpha.www.Department.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		// convert department dto to department jpa entity
		Department department = new Department(
				departmentDto.getId(), 
				departmentDto.getDepartmentName(), 
				departmentDto.getDepartmentDescription(), 
				departmentDto.getDepartmentCode());
		
		// save to db
		Department savedDeparment = departmentRepository.save(department);
		
		// convert department jpa entity to department dto
		DepartmentDto savedDepartmentDto = new DepartmentDto(
				savedDeparment.getId(), 
				savedDeparment.getDepartmentName(), 
				savedDeparment.getDepartmentDescription(), 
				savedDeparment.getDepartmentCode());
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		// entity to dto
		DepartmentDto departmentDto = new DepartmentDto(
				department.getId(), 
				department.getDepartmentName(), 
				department.getDepartmentDescription(), 
				department.getDepartmentCode());
		return departmentDto;
	}

}
