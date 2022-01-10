package com.th.ws.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import https.www_torryharris_com.soap_ws_demo.GetEmployeeResponse;

@ControllerAdvice
public class CustomExceptionHandler {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(EmployeeNotFoundException.class)
	public GetEmployeeResponse handleEmployeeNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		GetEmployeeResponse employeeResponse = new GetEmployeeResponse();
		employeeResponse.setEmployeeType(null);
		return employeeResponse;
	}

}