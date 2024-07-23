package com.gururaj.csa.exception;

import lombok.Getter;

public class CarNotFoundByIdException extends RuntimeException{
	
	@Getter
	private String message;

	public CarNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	

}
