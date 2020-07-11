package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userModelRepository;

	public UserModel findById(Long userId) {
		return userModelRepository.findById(userId).orElse(null);
	}
	
	
}
