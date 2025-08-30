package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFounDException(ResourceNotFoundException ex,
			WebRequest request) {
		ErrorResponseDto error = new ErrorResponseDto();

		error.setApiPath(request.getDescription(false));
		error.setErrorMessage(ex.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND);
		error.setErrorTime(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ResourceNotModifiedException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotModifiedException(ResourceNotModifiedException ex,WebRequest request)
	{
		ErrorResponseDto error = new ErrorResponseDto();

		error.setApiPath(request.getDescription(false));
		error.setErrorMessage(ex.getMessage());
		error.setErrorCode(HttpStatus.CONFLICT);
		error.setErrorTime(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<ErrorResponseDto> handleGlobalException(GlobalException ex,WebRequest request)
	{
		ErrorResponseDto error = new ErrorResponseDto();

		error.setApiPath(request.getDescription(false));
		error.setErrorMessage(ex.getMessage());
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
		error.setErrorTime(LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}
	
}
