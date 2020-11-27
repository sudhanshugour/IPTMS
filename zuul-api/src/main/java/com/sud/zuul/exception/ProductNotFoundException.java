package com.sud.zuul.exception;

public class ProductNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(long id) {
		super("there is no product with id-"+id);
	}
	public ProductNotFoundException() {
		super("product not found");
	}
}
