package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix="designation-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesignationContactInfoDto {

	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;
}
