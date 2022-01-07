package com.th.ws.demo.service;

import org.springframework.stereotype.Service;

import https.www_torryharris_com.soap_ws_demo.Employee;

@Service
public class EmployeeService {

	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmployeeId(101);
		emp.setFirstName("Sonu");
		emp.setSalary(50000);
		return emp;

	}

}
