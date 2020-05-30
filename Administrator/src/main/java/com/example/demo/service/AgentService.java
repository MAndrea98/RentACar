package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AgentRepository;

@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository;
}
