package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.TrainingTimeSlot;

public interface ITrainingTimeSlotService {

	public TrainingTimeSlot saveTrainingTimeSlot(TrainingTimeSlot traintimeslot);

	public List<TrainingTimeSlot> getAllTrainingTimeSlots();
	
	
	
}
