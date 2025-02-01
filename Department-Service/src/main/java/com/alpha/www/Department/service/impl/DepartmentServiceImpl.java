package com.alpha.www.Department.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.alpha.www.Department.dto.DepartmentDto;
import com.alpha.www.Department.entity.Department;
import com.alpha.www.Department.exception.ResourceNotFoundException;
import com.alpha.www.Department.mapper.DepartmentMapper;
import com.alpha.www.Department.repository.DepartmentRepository;
import com.alpha.www.Department.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
//	private ModelMapper modelMapper;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		// convert department dto to department jpa entity
//		Department department = new Department(
//				departmentDto.getId(), 
//				departmentDto.getDepartmentName(), 
//				departmentDto.getDepartmentDescription(), 
//				departmentDto.getDepartmentCode());
		
//		Department department = modelMapper.map(departmentDto, Department.class);
		Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
		
		// save to db
		Department savedDeparment = departmentRepository.save(department);
		
		// convert department jpa entity to department dto
//		DepartmentDto savedDepartmentDto = new DepartmentDto(
//				savedDeparment.getId(), 
//				savedDeparment.getDepartmentName(), 
//				savedDeparment.getDepartmentDescription(), 
//				savedDeparment.getDepartmentCode());
		
//		DepartmentDto savedDepartmentDto = modelMapper.map(savedDeparment, DepartmentDto.class);
		DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDeparment);
		
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository
				.findByDepartmentCode(departmentCode)
				.orElseThrow(() -> new ResourceNotFoundException("Department", "code", departmentCode));
		
		// entity to dto
//		DepartmentDto departmentDto = new DepartmentDto(
//				department.getId(), 
//				department.getDepartmentName(), 
//				department.getDepartmentDescription(), 
//				department.getDepartmentCode());
		
//		DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
		DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);
		return departmentDto;
	}

}
