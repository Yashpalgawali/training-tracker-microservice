package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Training;

@Repository("trainrepo")
public interface TrainingRepository extends MongoRepository<Training, String> {

	@Query("UPDATE Training t SET t.trainingName=:training_name WHERE t.id=:id")
	public Training updateTraining(String id,String training_name);
}
