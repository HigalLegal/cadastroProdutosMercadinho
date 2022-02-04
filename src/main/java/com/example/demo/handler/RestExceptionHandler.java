package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.model.error.ErrorMessage;
import com.example.demo.model.exception.ResourceNoutFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNoutFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(ResourceNoutFoundException exception) {
		ErrorMessage error = new ErrorMessage("Not found", HttpStatus.NOT_FOUND.value(), exception.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}

