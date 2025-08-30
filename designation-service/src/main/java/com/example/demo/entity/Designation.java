package com.example.demo.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="tbl_designation")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class Designation {

	@Column(name = "designation_id")
	@Id
	@SequenceGenerator(name="designation_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "designation_seq",strategy = GenerationType.AUTO)
	Long designationId;

	@Size(min = 2 , max= 200,message = "Designation name should have at least 2 characters")
	@NotNull(message = "Designation name cannot be null")
	@NotEmpty(message = "Designation name cannot be blank")
	@Column(name="desig_name")
	String designationName;
	 
}
