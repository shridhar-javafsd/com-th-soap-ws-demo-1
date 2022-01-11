package com.th.ws.demo.endpoint;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.th.ws.demo.model.Employee;
import com.th.ws.demo.service.EmployeeService;

import https.www_torryharris_com.soap_ws_demo.AddEmployeeRequest;
import https.www_torryharris_com.soap_ws_demo.DeleteEmployeeRequest;
import https.www_torryharris_com.soap_ws_demo.EmployeeType;
import https.www_torryharris_com.soap_ws_demo.GetAllEmployeesRequest;
import https.www_torryharris_com.soap_ws_demo.GetAllEmployeesResponse;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeRequest;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeResponse;
import https.www_torryharris_com.soap_ws_demo.UpdateEmployeeRequest;

@Endpoint
public class EmployeeEndpoint {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeService employeeService;

	public EmployeeEndpoint() {
		super();
		LOG.info("EmployeeEndPoint");
	}

	// similar to controller method

	// getAllEmployees
	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "getAllEmployeeRequest")
	@ResponsePayload
	public GetAllEmployeesResponse getAllEmployees() {
		LOG.info("getAllEmployees");
		List<Employee> empList = employeeService.getAllEmployees();
		GetAllEmployeesResponse response = new GetAllEmployeesResponse();
		return response;
	}

	// getEmployeeById
	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		LOG.info("getEmployee " + request.getEmployeeId());
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee emp = employeeService.getEmployeeById(request.getEmployeeId());
		EmployeeType empt = new EmployeeType();
		// see the import - import org.springframework.beans.BeanUtils;
		BeanUtils.copyProperties(emp, empt);
		response.setEmployeeType(empt);
		LOG.info(emp.toString());
		return response;
	}

	// addEmployee
	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "addEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		LOG.info("addEmployee " + request.getEmployeeId() + request.getFirstName() + request.getSalary());
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee employee = new Employee();
//		BeanUtils.copyProperties(employee, request); // wrong!
		BeanUtils.copyProperties(request, employee);
		LOG.info(employee.toString());
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(employeeService.addEmployee(employee), empt);
		response.setEmployeeType(empt);
		return response;
	}

	// updateEmployee
	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "updateEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		LOG.info("updateEmployee " + request.getEmployeeId() + request.getFirstName() + request.getSalary());
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee employee = new Employee();
//		BeanUtils.copyProperties(employee, request); // wrong!
		BeanUtils.copyProperties(request, employee);
		LOG.info(employee.toString());
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(employeeService.updateEmployee(employee), empt);
		response.setEmployeeType(empt);
		return response;
	}

	// deleteEmployee
	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse updateEmployee(@RequestPayload DeleteEmployeeRequest request) {
		LOG.info("deleteEmployee " + request.getEmployeeId());
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(employeeService.deleteEmployee(request.getEmployeeId()), empt);
		response.setEmployeeType(empt);
		return response;
	}

}
