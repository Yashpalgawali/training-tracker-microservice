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
@Table(name="tbl_company")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class Company {

	@Column(name = "company_id")
	@Id
	@SequenceGenerator(name="comp_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "comp_seq",strategy = GenerationType.AUTO)
	Long companyId;
	
	@Size(min = 2 , max= 200,message = "Company name should ahve at least 2 characters")
	@NotNull(message = "Company name cannot be null")
	@NotEmpty(message = "Company name cannot be blank")
	@Column(name="comp_name")
	String companyName;
}
