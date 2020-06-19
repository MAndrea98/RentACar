package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;
	
	public Request findByParameters(Renter renter, EndUser endUser, String status) {
		return requestRepository.findByRenterAndEndUserAndStatus(renter, endUser, status);
	}
}
