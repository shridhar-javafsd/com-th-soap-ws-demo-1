package com.th.ws.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class EmployeeEndpoint {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	public EmployeeEndpoint() {
		super();
		LOG.info("EmployeeEmdPoint");
	}

	// similar to controller method

//	public GetEmployeeResponse getEmployee() {
	public Object getEmployee() {
		return null;
	}

}
