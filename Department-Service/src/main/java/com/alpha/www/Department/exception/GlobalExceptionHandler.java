package com.alpha.www.Department.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
			ResourceNotFoundException exception, 
			WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				exception.getMessage(), 
				webRequest.getDescription(false), 
				"DEPARTMENT_NOT_FOUND");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(
			Exception exception, 
			WebRequest webRequest){
		
		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				exception.getMessage(), 
				webRequest.getDescription(false), 
				"INTERNAL_SERVER_ERROR");
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
