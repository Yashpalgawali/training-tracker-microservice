package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Company;
import com.example.demo.exception.GlobalException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.ICompanyService;

@Service("compserv")
public class CompanyServImpl implements ICompanyService {

	private final CompanyRepository comprepo;

	public CompanyServImpl(CompanyRepository comprepo) {
		super();
		this.comprepo = comprepo;
	}

	@Override
	public Company saveCompany(Company company) {
		Company compObject = comprepo.save(company);
		if(compObject!=null) {
			return compObject;
		}
		else {
			throw new GlobalException("Company "+company.getCompanyName()+" is not saved");
		}
	}

	@Override
	public Company getCompanyById(Long comp_id) {
		 
		return comprepo.findById(comp_id).orElseThrow(() -> new ResourceNotFoundException("Company not found") );
	}

	@Override
	@Transactional
	public int updateCompany(Company company) {
		int result = comprepo.updateCompany(company.getCompanyId(), company.getCompanyName());
		if(result>0) {
			return result;
		}
		else {
			throw new GlobalException("Company not updated");
		}
		
	}

	@Override
	public List<Company> getAllCompanies() {
		return comprepo.findAll();
	}

}
