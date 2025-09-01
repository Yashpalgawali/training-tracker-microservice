package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.ResponseDto;
import com.example.demo.entity.TrainingTimeSlot;
import com.example.demo.service.ITrainingTimeSlotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("traintimeslot")
public class TrainingTimeSlotController {

	private final ITrainingTimeSlotService traintimeslotserv;

	public TrainingTimeSlotController(ITrainingTimeSlotService traintimeslotserv) {
		super();
		this.traintimeslotserv = traintimeslotserv;
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDto> saveTrainingTimeSlot(@Valid @RequestBody TrainingTimeSlot timeslot) {
		traintimeslotserv.saveTrainingTimeSlot(timeslot);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Training Time Slot "+timeslot.getTrainingTimeSlot()+" is saved successfully" ));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TrainingTimeSlot>> getAllTrainingTimeSlots() {
		var tList = traintimeslotserv.getAllTrainingTimeSlots();
		return ResponseEntity.status(HttpStatus.CREATED).body(tList);
	}
}
