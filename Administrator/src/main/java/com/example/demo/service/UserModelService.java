package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserModelRepository;

@Service
public class UserModelService {

	@Autowired
	private UserModelRepository userModelRepository;
}
