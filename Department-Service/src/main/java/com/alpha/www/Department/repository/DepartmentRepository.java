package com.alpha.www.Department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.www.Department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
