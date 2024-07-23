package com.gururaj.csa.utility;

public class ResponseStructure<T> {
	
	private int httpStatusCode;
	private String message;
	private T data;
	
	public int getHttpStatusCode() {
		return httpStatusCode;
	}
	public ResponseStructure<T> setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ResponseStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	public T getData() {
		return data;
	}
	public ResponseStructure<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	

}
