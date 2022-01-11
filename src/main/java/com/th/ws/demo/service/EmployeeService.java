package com.th.ws.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.ws.demo.exception.EmployeeNotFoundException;
import com.th.ws.demo.model.Employee;
import com.th.ws.demo.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Employee> getAllEmployees() {
		LOG.info("getAllEmployees");
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		LOG.info("getEmployeeById " + employeeId);
		Optional<Employee> empOptional = employeeRepository.findById(employeeId);
		if (empOptional.isPresent())
			return empOptional.get();
		throw new EmployeeNotFoundException("Employee with id " + employeeId + " does not exist.");
	}

	@Override
	public Employee addEmployee(Employee employee) {
		LOG.info("addEmployee " + employee.toString());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		LOG.info("updateEmployee " + employee.toString());
		if (employeeRepository.existsById(employee.getEmployeeId()))
			return employeeRepository.save(employee);
		throw new EmployeeNotFoundException("Employee with id " + employee.getEmployeeId() + " does not exist.");
	}

	@Override
	public Employee deleteEmployee(int employeeId) {
		LOG.info("deleteEmployee " + employeeId);
		Optional<Employee> empo = employeeRepository.findById(employeeId);
		if (empo.isPresent()) {
			employeeRepository.deleteById(employeeId);
			return empo.get();
		}
		throw new EmployeeNotFoundException("Employee with id " + employeeId + " does not exist.");
	}

}
