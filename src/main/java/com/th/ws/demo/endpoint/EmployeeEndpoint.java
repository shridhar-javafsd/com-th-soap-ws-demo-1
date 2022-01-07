package com.th.ws.demo.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.www_torryharris_com.soap_ws_demo.Employee;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeRequest;
import https.www_torryharris_com.soap_ws_demo.GetEmployeeResponse;

@Endpoint
public class EmployeeEndpoint {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	public EmployeeEndpoint() {
		super();
		LOG.info("EmployeeEmdPoint");
	}

	// similar to controller method

	@PayloadRoot(namespace = "https://www.torryharris.com/soap-ws-demo", localPart = "getEmployeeRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
		LOG.info("getEmployee " + request.getEmployeeId());
		GetEmployeeResponse response = new GetEmployeeResponse();
		Employee emp = new Employee(); // data will come from DB
		emp.setEmployeeId(101);
		emp.setFirstName("Sonu");
		emp.setSalary(50000);
		response.setEmployee(emp);
		return response;
	}
}
