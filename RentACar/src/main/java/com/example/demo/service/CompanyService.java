package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	CompanyRepository companyRepository;
	
	public Company save(Company c) {
		return companyRepository.save(c);
	}
	
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Company findByPoslovniMaticniBroj(String poslovniMaticniBroj) {
		return companyRepository.findByPoslovniMaticniBroj(poslovniMaticniBroj);
	}
}
