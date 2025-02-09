package com.alpha.www.Department.mapper;

import com.alpha.www.Department.dto.DepartmentDto;
import com.alpha.www.Department.entity.Department;

public class DepartmentMapper2 {

	
	// dto to entity
	public static Department dtoToEntity(DepartmentDto departmentDto) {
		return new Department(
				departmentDto.getId(), 
				departmentDto.getDepartmentName(), 
				departmentDto.getDepartmentDescription(), 
				departmentDto.getDepartmentCode());
	}
	
	// entity to dto
	public static DepartmentDto entityToDto(Department department) {
		return new DepartmentDto(
				department.getId(), 
				department.getDepartmentName(), 
				department.getDepartmentDescription(), 
				department.getDepartmentCode());
	}
}
