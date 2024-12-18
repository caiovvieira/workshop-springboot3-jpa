package com.myproject.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myproject.course.services.exceptions.DatabaseException;
import com.myproject.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice

public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standErr = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standErr);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException exception, HttpServletRequest request){
		
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standErr = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(standErr);
	}
	
}


