package com.th.ws.demo.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.th.ws.demo.service.EmployeeService;

import https.www_torryharris_com.soap_ws_demo.Employee;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeRequest;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeResponse;

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

	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		LOG.info("getEmployee " + request.getEmployeeId());
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee emp = employeeService.getEmployeeById(request.getEmployeeId());
		response.setEmployee(emp);
		return response;
	}
}
