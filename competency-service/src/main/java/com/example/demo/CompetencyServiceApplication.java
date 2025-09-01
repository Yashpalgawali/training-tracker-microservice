package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.dto.CompetencyContactInfoDto;

@SpringBootApplication
@EnableConfigurationProperties(value = {CompetencyContactInfoDto.class})
public class CompetencyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompetencyServiceApplication.class, args);
	}

}
