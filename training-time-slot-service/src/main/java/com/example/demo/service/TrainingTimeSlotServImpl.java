package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TrainingTimeSlot;
import com.example.demo.execption.GlobalException;
import com.example.demo.repository.TrainingTimeSlotRepository;

@Service("traintimeslotserv")
public class TrainingTimeSlotServImpl implements ITrainingTimeSlotService {

	private final TrainingTimeSlotRepository traintimerepo;
	
	public TrainingTimeSlotServImpl(TrainingTimeSlotRepository traintimerepo) {
		super();
		this.traintimerepo = traintimerepo;
	}

	@Override
	public TrainingTimeSlot saveTrainingTimeSlot(TrainingTimeSlot traintimeslot) {
		
		TrainingTimeSlot savedObject = traintimerepo.save(traintimeslot);
		if(savedObject!=null) {
			return savedObject;
		}
		else {
			throw new GlobalException("Training Time Slot is saved");
		}
	}

	@Override
	public List<TrainingTimeSlot> getAllTrainingTimeSlots() {
		List<TrainingTimeSlot> slotList = traintimerepo.findAll();
		if(!slotList.isEmpty()) {
			return slotList;
		}
		else {
			throw new RuntimeException("No Training Time Slots present");
		}
	}

}
