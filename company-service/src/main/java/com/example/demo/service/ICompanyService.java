package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Company;

public interface ICompanyService {

	public Company saveCompany(Company company);
	
	public Company getCompanyById(Long comp_id);
	
	public int updateCompany(Company company);
	
	public List<Company> getAllCompanies();
}
