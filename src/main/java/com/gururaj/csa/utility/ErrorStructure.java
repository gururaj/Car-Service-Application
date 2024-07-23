package com.gururaj.csa.utility;

import lombok.Getter;
import lombok.Setter;

public class ErrorStructure<T> {
	
	@Getter
	@Setter
	private int httpStatusCode;
	@Getter
	@Setter
	private String errorMessage;
	@Getter
	@Setter
	private T data;

}
