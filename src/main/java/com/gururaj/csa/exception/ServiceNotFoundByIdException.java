package com.gururaj.csa.exception;

import lombok.Getter;

@Getter
public class ServiceNotFoundByIdException extends RuntimeException{
	
	private String message;

	public ServiceNotFoundByIdException(String message) {
		this.message = message;
	}
	
}
