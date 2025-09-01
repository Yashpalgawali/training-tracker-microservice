package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		ErrorResponseDto error = new ErrorResponseDto(
					request.getDescription(false),HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now()
				);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(value = ResourceNotModifiedException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotModifiedException(ResourceNotModifiedException ex, WebRequest request) {
		
		ErrorResponseDto error = new ErrorResponseDto(
					request.getDescription(false),HttpStatus.CONFLICT,ex.getMessage(),LocalDateTime.now()
				);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(value = GlobalException.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(GlobalException ex, WebRequest request) {
		
		ErrorResponseDto error = new ErrorResponseDto(
					request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),LocalDateTime.now()
				);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
}
