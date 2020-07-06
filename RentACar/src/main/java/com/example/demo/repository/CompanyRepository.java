package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {

	@Override
	Page<Company> findAll(Pageable pageable);
	
	Company findByPoslovniMaticniBroj(String poslovniMaticniBroj);
	
}
