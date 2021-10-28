package com.neosoft.NeosoftDemo;

public class AppValidation extends RuntimeException{
	
	public AppValidation() {
		
	}
	
	public AppValidation(String message) {
		
		super(message);
	}
	
	public AppValidation(String message, Throwable t) {
		
		super(message, t);
	}

}
