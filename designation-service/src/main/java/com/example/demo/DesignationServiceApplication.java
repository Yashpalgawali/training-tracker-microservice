package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.demo.dto.DesignationContactInfoDto;

@SpringBootApplication
@EnableConfigurationProperties(value = {DesignationContactInfoDto.class})
public class DesignationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignationServiceApplication.class, args);
	}

}
