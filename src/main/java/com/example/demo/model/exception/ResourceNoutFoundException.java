package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNoutFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNoutFoundException(String mensagem) {
		super(mensagem);
	}
	
}
