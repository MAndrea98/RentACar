package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EndUser;
import com.example.demo.repository.EndUserRepostiory;

@Service
public class EndUserService {

	@Autowired
	private EndUserRepostiory endUserRepository;
	
	public Optional<EndUser> findByIdUser(Long id) {
		return endUserRepository.findByIdUser(id);
	}

}
