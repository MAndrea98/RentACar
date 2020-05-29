package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EndUser;
import com.example.demo.repository.EndUserRepository;

@Service
public class EndUserService {

	@Autowired
	private EndUserRepository endUserRepository;
	
	public EndUser findByIdUser(Long idUser) {
		return endUserRepository.findByIdUser(idUser).orElse(null);
	}
}
