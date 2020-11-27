package com.cts.iptms.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(InsurerDetailNotFoundException.class)
	public ResponseEntity<String> insurerDetailNotFoundExceptionHandler(InsurerDetailNotFoundException ex){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
		
	}
	
	
	@ExceptionHandler(PatientDetailNotFoundException.class)
	public ResponseEntity<String> patientDetailNotFoundExceptionnHandler(PatientDetailNotFoundException ex){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NO_CONTENT);
		
	}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<String> insurerDetailNotFoundExceptionHandler(InvalidTokenException ex){
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
		
	}
	

}
