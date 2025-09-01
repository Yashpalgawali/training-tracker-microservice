package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Competency;

@Repository("competencyrepo")
public interface CompetencyRepository extends MongoRepository<Competency, String> {

}
