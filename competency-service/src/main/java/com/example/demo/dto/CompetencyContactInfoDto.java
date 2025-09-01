package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix="competency-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyContactInfoDto {
	
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;
}
