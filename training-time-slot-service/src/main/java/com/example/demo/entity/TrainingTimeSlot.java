package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "training_time_slot")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrainingTimeSlot {

	@Id
	private String _id;

	@NotNull(message = "Training Time Slot cannot be null. Provide some Value.")
	private String trainingTimeSlot;

}
