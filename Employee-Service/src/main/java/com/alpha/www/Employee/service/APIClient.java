package com.alpha.www.Employee.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alpha.www.Employee.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
	@GetMapping("api/department/{department-code}")
	DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);
}
