package com.th.ws.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.th.ws.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}


//SELECT * FROM employee_table;
//
//insert into employee_table values (101, 'Sonu', 50000);
//insert into employee_table values (102, 'Monu', 58000);
//insert into employee_table values (103, 'Tonu', 54000);
