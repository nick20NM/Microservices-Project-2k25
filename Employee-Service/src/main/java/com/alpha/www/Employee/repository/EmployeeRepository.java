package com.alpha.www.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.www.Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
