package com.example.demo.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class GlobalException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8679791417388107093L;

	public GlobalException(String msg) {
		super(msg);
	}

}
