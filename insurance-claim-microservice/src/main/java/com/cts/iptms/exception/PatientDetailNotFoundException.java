package com.cts.iptms.exception;

public class PatientDetailNotFoundException extends RuntimeException {

	
	public PatientDetailNotFoundException() {
		super("you are trying to find a non existing Patient");
	}

	
	
}
