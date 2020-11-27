package com.cts.iptms.exception;



public class InvalidTokenException extends RuntimeException{

	public InvalidTokenException() {
		super("the token is expired or wrong");
		
	}

}