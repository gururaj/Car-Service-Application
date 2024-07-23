package com.gururaj.csa.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gururaj.csa.exception.CarNotFoundByIdException;
import com.gururaj.csa.exception.ServiceNotFoundByIdException;

@RestControllerAdvice
public class ApplicationHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>  carNotFoundById(CarNotFoundByIdException e){
		
		ErrorStructure<String> errorStructure = new ErrorStructure<String>();
		errorStructure.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(e.getMessage());
		errorStructure.setData("Car with requested Id is not present in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>>  serviceNotFoundById(ServiceNotFoundByIdException e){
		
		ErrorStructure<String> errorStructure = new ErrorStructure<String>();
		errorStructure.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setErrorMessage(e.getMessage());
		errorStructure.setData("Service with requested Id is not present in the database");
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
}
