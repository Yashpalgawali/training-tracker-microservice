package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Training;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.ResourceNotModifiedException;
import com.example.demo.repository.TrainingRepository;
import com.example.demo.service.ITrainingService;

@Service("trainserv")
public class TrainingServImpl implements ITrainingService {

	private final TrainingRepository trainrepo;

	public TrainingServImpl(TrainingRepository trainrepo) {
		super();
		this.trainrepo = trainrepo;
	}

	@Override
	public Training saveTraining(Training training) {
 
		return trainrepo.save(training);
	}

	@Override
	public Training getTrainingById(String training_id) {
	
		return trainrepo.findById(training_id).orElseThrow(()-> new ResourceNotFoundException("No Training Found for given Id "+training_id));
	}

	@Override
	public List<Training> getAllTrainings() {
	 
		return trainrepo.findAll();
	}

	@Override
	@Transactional
	public int updateTraining(Training training) {
		var result =  trainrepo.save(training);

		if(result!=null) {
			return 1;
		}
		else {
			throw new ResourceNotModifiedException("Training "+training.getTrainingName()+" is not Updated");
		}
	}

}
