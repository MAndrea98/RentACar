package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userModelRepository;
	
	public Optional<UserModel> findById(Long id){
		return userModelRepository.findById(id);
	}
	
	public Optional<UserModel> findByUsername(String u){
		return userModelRepository.findByUsername(u);
	}
	

	public UserModel save(UserModel u) {
		return userModelRepository.save(u);
	}
}
