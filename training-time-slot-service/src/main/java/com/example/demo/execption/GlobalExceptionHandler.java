package com.example.demo.execption;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(GlobalException ex,WebRequest request) {

		ErrorResponseDto error = new ErrorResponseDto(
					 request.getDescription(false),
					 HttpStatus.INTERNAL_SERVER_ERROR,
					 ex.getMessage(),
					 LocalDateTime.now()
				);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

}
