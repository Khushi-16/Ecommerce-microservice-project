package com.example.rest.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,String>> ResourcesNotFound(ResourceNotFoundException ex){
		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	

}
