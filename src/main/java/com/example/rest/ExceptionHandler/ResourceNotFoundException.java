package com.example.rest.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException{
	
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
