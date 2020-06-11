package com.springboot.crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	// exception handling code here
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handlerException(EmployeeNotFoundException exc){
		
		//create a EmployeeErrorResponse
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handlerException(Exception exc){
		
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployeeErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
