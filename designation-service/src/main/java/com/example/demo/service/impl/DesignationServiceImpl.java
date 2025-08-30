package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Designation;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DesignationRepository;
import com.example.demo.service.IDesignationService;

@Service("desigserv")
public class DesignationServiceImpl implements IDesignationService {

	private final DesignationRepository desigrepo;

	public DesignationServiceImpl(DesignationRepository desigrepo) {
		super();
		this.desigrepo = desigrepo;
	}

	@Override
	public Designation saveDesignation(Designation designation) {
		Designation desig = desigrepo.save(designation);
		if(desig!=null)
		{
			return desig;
		}
		throw new GlobalException("Designation "+designation.getDesignationName()+" is not saved");
	}

	@Override
	public Designation getDesignationById(Long desig_id) {
		 
		return desigrepo.findById(desig_id).orElseThrow(()-> new ResourceNotFoundException("No Designation for given ID "+desig_id));
	}

	@Override
	public List<Designation> getAllDesignations() {
		
		return desigrepo.findAll();
	}

	@Override
	public int updateDesignation(Designation designation) {
		int result = desigrepo.updateDesignation(designation.getDesignationId(), designation.getDesignationName());
		if(result>0) {
			return result;
		}
		throw new GlobalException("Designation "+designation.getDesignationName()+" is not updated");
	}

}
