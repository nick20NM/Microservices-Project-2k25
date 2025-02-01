package com.alpha.www.Department.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.alpha.www.Department.dto.DepartmentDto;
import com.alpha.www.Department.entity.Department;

@Mapper
public interface DepartmentMapper {
	
	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

	DepartmentDto mapToDepartmentDto(Department department);
	
	Department mapToDepartment(DepartmentDto departmentDto);
}
