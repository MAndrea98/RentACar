package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agent;
import com.example.demo.repository.AgentRepository;

@Service
public class AgentService {

	@Autowired
	AgentRepository agentRepository;
	
	public Agent save(Agent a) {
		return agentRepository.save(a);
	}
	
	public List<Agent> findAll() {
		return agentRepository.findAll();
	}
	
}
