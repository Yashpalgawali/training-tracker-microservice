package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.dto.ResponseDto;
import com.example.demo.entity.Competency;
import com.example.demo.service.ICompetencyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("competency")
@Validated
public class CompetencyController {

	private final ICompetencyService competencyserv;

	public CompetencyController(ICompetencyService competencyserv) {
		super();
		this.competencyserv = competencyserv;
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveCompetency(@Valid @RequestBody Competency competency) {
		competencyserv.saveCompetency(competency);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Competency "+competency.getScore()+" is saved successfully"));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Competency> getCompetencyById(@PathVariable String id) {
		var obj =competencyserv.getCompetencyById(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Competency>> getAllCompetency() {
		var obj =competencyserv.getAllCompetencies();
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateCompetency(@Valid @RequestBody Competency competency) {
		competencyserv.updateCompetency(competency);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(), "Competency "+competency.getScore()+" is updated successfully"));
	}
	
}
