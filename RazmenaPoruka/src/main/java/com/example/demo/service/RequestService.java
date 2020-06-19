package com.example.demo.service;

import java.util.List;

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

	public Request save(Request request) {
		return requestRepository.save(request);
	}

	public List<Request> findAll(){
		return requestRepository.findAll();
	}
	
	public Request findByParameters(Renter renter, EndUser endUser, String status) {
		return requestRepository.findByRenterAndEndUserAndStatus(renter, endUser, status);
	}

}
