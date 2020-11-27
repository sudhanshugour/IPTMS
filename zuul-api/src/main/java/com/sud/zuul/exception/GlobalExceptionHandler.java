package com.sud.zuul.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(ProductNotFoundException ex){
		LOGGER.info("Start");

		ResponseEntity<String> re=new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		LOGGER.info("response:", re);
		LOGGER.info("End");
		return re;
	}


	@ExceptionHandler(UserMisMatch.class)
	public ResponseEntity<String> productNotFoundException(UserMisMatch ex){
		LOGGER.info("Start");

		ResponseEntity<String> re=new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		LOGGER.info("response:", re);
		LOGGER.info("End");
		return re;
	}
}
