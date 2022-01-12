package com.th.ws.demo.endpoint;

import java.util.ArrayList;

import java.util.List;

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
import https.www_torryharris_com.soap_ws_demo.GetAllEmployeesResponse;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeRequest;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeResponse;
import https.www_torryharris_com.soap_ws_demo.UpdateEmployeeRequest;

@Endpoint
public class EmployeeEndpoint {

	private final String NAMESPACE_URI = "https://www.torryharris.com/soap-ws-demo";

	@Autowired
	EmployeeService employeeService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
	@ResponsePayload
	public GetAllEmployeesResponse getAllEmployees() {
		List<Employee> empList = employeeService.getAllEmployees();
		List<EmployeeType> emptList = new ArrayList<>();
		GetAllEmployeesResponse response = new GetAllEmployeesResponse();
		empList.forEach(emp -> {
			EmployeeType empt = new EmployeeType();
			BeanUtils.copyProperties(emp, empt);
			emptList.add(empt);
		});
		response.getEmployeesType().addAll(emptList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee emp = employeeService.getEmployeeById(request.getEmployeeId());
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(emp, empt);
		response.setEmployeeType(empt);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee employee = new Employee();
		BeanUtils.copyProperties(request, employee);
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(employeeService.addEmployee(employee), empt);
		response.setEmployeeType(empt);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee employee = new Employee();
		BeanUtils.copyProperties(request, employee);
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(employeeService.updateEmployee(employee), empt);
		response.setEmployeeType(empt);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse updateEmployee(@RequestPayload DeleteEmployeeRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeType empt = new EmployeeType();
		BeanUtils.copyProperties(employeeService.deleteEmployee(request.getEmployeeId()), empt);
		response.setEmployeeType(empt);
		return response;
	}

}
