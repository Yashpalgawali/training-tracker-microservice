package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DesignationContactInfoDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Designation;
import com.example.demo.service.IDesignationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("designation")
@Validated
public class DesignationController {

//	@Value("${build.version}")
//	private String buildInfo;
		
	@Autowired
	private DesignationContactInfoDto designationContactInfoDto;
	
	private final IDesignationService desigserv;

	public DesignationController(IDesignationService desigserv) {
		super();
		this.desigserv = desigserv;
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveDesignation(@Valid @RequestBody Designation designation) {

		desigserv.saveDesignation(designation);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(),
				"Designation " + designation.getDesignationName() + " is saved successfully"));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Designation> getDesignationById(@PathVariable Long id) {

		Designation desig = desigserv.getDesignationById(id);
		return ResponseEntity.status(HttpStatus.OK).body(desig );
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Designation>> getAllDesignation() {

		List<Designation> desigList = desigserv.getAllDesignations();
		return ResponseEntity.status(HttpStatus.OK).body(desigList );
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateDesignation(@Valid @RequestBody Designation designation) {

		desigserv.updateDesignation(designation);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(),
				"Designation " + designation.getDesignationName() + " is updated successfully"));
	}
//	@GetMapping("/build-info")
//	public ResponseEntity<String> getBuildInfo(){
//		return ResponseEntity.status(HttpStatus.OK).body(buildInfo);
//	}
	
	@GetMapping("/contact-info")
	public ResponseEntity<DesignationContactInfoDto> getContactInfo(){
		return ResponseEntity.status(HttpStatus.OK).body(designationContactInfoDto);
	}
}
