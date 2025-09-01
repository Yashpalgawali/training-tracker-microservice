package com.example.demo.Dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ErrorResponseDto {

	private String apiPath;
	
	private HttpStatus errorStatus;
	
	private String errorMessage;
	
	private LocalDateTime errorTime;
	
}
