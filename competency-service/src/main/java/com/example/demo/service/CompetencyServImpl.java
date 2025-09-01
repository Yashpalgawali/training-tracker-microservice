package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Competency;
import com.example.demo.exceptions.GlobalException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.CompetencyRepository;

@Service("competencyserv")
public class CompetencyServImpl implements ICompetencyService {

	private final CompetencyRepository competencyrepo;

	public CompetencyServImpl(CompetencyRepository competencyrepo) {
		super();
		this.competencyrepo = competencyrepo;
	}

	@Override
	public Competency saveCompetency(Competency competency) {
		var savedObject = competencyrepo.save(competency);
		if(savedObject!=null) {
			return savedObject;
		}
		else {
			throw new GlobalException("Competency "+competency.getScore()+" is not saved ");
		}
	}

	@Override
	public List<Competency> getAllCompetencies() {
		var cList = competencyrepo.findAll();
		if(!cList.isEmpty()) {
			return cList;
		}
		else {
			throw new GlobalException("No Competencies Found");
		}
	}

	@Override
	public Competency getCompetencyById(String id) {
	 
		return competencyrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Competency found for given ID "+id));
	}

	@Override
	public Competency updateCompetency(Competency competency) {
		var updatedObject = competencyrepo.save(competency);
		if(updatedObject!=null) {
			return updatedObject;
		}
		throw new GlobalException("Competency "+competency.getScore()+" is not updated");
	}

}
