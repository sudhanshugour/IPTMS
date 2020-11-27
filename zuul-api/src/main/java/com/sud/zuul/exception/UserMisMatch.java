package com.sud.zuul.exception;

public class UserMisMatch extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserMisMatch(String adminId,String accessId) {
		super("Your login Id is - "+adminId+" and trying to access - "+accessId+" in your data");
	}
	
	public UserMisMatch() {
		super(" trying to access other use data");
	}
}
