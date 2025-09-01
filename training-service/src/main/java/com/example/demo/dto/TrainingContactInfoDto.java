package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix="training-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingContactInfoDto {
	
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;
}
