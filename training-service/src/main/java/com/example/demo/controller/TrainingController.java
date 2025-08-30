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
import com.example.demo.entity.Training;
import com.example.demo.service.ITrainingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("training")
@Validated
public class TrainingController {

	private final ITrainingService trainserv;

	public TrainingController(ITrainingService trainserv) {
		super();
		this.trainserv = trainserv;
	}
	
	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveTraining(@Valid @RequestBody Training training )
	{
		trainserv.saveTraining(training);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(),"Training "+training.getTrainingName()+" is created successfully"));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Training>> getAllTrainings()
	{
		var trainList = trainserv.getAllTrainings();
		return ResponseEntity.status(HttpStatus.OK).body(trainList);
	}
	
	@GetMapping("/{trainId}")
	public ResponseEntity<Training> getTrainingById(@PathVariable String trainId)
	{
		var training= trainserv.getTrainingById(trainId);
		return ResponseEntity.status(HttpStatus.OK).body(training);
	}
	
	@PutMapping("/")
	public ResponseEntity<ResponseDto> updateTraining(@Valid @RequestBody Training training )
	{
		System.err.println(training.toString());
		trainserv.updateTraining(training);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.toString(),"Training "+training.getTrainingName()+" is Updated successfully"));
	}
}
