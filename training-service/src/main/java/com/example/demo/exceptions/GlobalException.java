package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class GlobalException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7267963160306970805L;

	public GlobalException(String msg) {
		super(msg);
	}

	
}
