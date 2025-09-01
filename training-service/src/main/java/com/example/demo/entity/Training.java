package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Document(collection = "tbl_training")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Training {

	@Id
	String _id;

	@Size(min = 2,max = 100,message = "Tranining name must have at least two characters")
	String trainingName;
}
