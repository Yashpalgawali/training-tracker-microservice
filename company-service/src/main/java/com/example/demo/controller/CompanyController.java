package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompanyContactInfoDto;
import com.example.demo.entity.Company;
import com.example.demo.service.ICompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("company")
public class CompanyController {

	@Value("${build.version}")
	private String buildInfo;
		
	@Autowired
	private CompanyContactInfoDto companyContactInfoDto;
	
	private final ICompanyService compserv;

	public CompanyController(ICompanyService compserv) {
		super();
		this.compserv = compserv;
	}
	
	@PostMapping("/")
	public ResponseEntity<String> saveCompany(@Valid @RequestBody Company company)
	{
		compserv.saveCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(company.getCompanyName()+" is saved successfully");
	}
	
	
	@PutMapping("/")
	public ResponseEntity<String> updateCompany(@Valid @RequestBody Company company)
	{
		compserv.updateCompany(company);
		return ResponseEntity.status(HttpStatus.OK).body(company.getCompanyName()+" is Updated successfully");
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Company>> getAllCompanies()
	{
		List<Company> complist = compserv.getAllCompanies();
		return ResponseEntity.status(HttpStatus.OK).body(complist);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id)
	{
		Company company = compserv.getCompanyById(id);
		return ResponseEntity.status(HttpStatus.OK).body(company);
	}
	
	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo(){
		return ResponseEntity.status(HttpStatus.OK).body(buildInfo);
	}
	
	@GetMapping("/contact-info")
	public ResponseEntity<CompanyContactInfoDto> getContactInfo(){
		return ResponseEntity.status(HttpStatus.OK).body(companyContactInfoDto);
	}
}
