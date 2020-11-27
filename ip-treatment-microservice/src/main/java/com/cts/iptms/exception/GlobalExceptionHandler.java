package com.cts.iptms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




	@RestControllerAdvice
	public class GlobalExceptionHandler {
		
		
	
		
		@ExceptionHandler(InvalidTokenException.class)
		public ResponseEntity<String> insurerDetailNotFoundExceptionHandler(InvalidTokenException ex){
			
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.FORBIDDEN);
			
		}
		


	}

