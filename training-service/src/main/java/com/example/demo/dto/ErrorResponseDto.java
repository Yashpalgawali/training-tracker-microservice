package com.example.demo.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponseDto {

	private String apiPath;
	
	private HttpStatus status;
	
	private String errorMessage;
	
	private LocalDateTime errorTime;
}
