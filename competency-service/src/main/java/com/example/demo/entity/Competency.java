package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "competency")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Competency {
	
	@Id
	private String _id;

	@NotNull(message = "Competency Score cannot be null. Provide some values")
	private Long score;
}
