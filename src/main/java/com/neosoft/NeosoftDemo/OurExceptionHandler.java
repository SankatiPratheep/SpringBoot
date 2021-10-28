package com.neosoft.NeosoftDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OurExceptionHandler {
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Error> HandleException(Throwable t) {
		Error e = new Error();
		e.setId(1);
		e.setName(t.getMessage());
		e.setException(t);
		e.setErrorDescription("ERR0056");
		ResponseEntity<Error> rs = new ResponseEntity<Error>(e, HttpStatus.SERVICE_UNAVAILABLE);
		
		return rs;

	}
	
	@ExceptionHandler(AppValidation.class)
	public ResponseEntity<Error> HandleException(AppValidation t) {
		Error e = new Error();
		e.setId(2);
		e.setName(t.getMessage());
		e.setException(t);
		e.setErrorDescription("MisMatch Details");
		ResponseEntity<Error> rs = new ResponseEntity<Error>(e, HttpStatus.CONFLICT);
		
		return rs;

	}
	
}
