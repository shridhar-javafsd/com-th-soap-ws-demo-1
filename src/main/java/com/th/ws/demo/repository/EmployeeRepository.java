package com.th.ws.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.th.ws.demo.model.Employee;

//public interface EmployeeRepository {

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
