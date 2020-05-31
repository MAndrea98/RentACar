package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Renter;
import com.example.demo.repository.RenterRepository;

@Service
public class RenterService {

	@Autowired
	private RenterRepository renterRepository;
	
	public Renter findById(Long id) {
		return renterRepository.findById(id).orElse(null);
	}
}
