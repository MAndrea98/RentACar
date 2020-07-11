package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Model;
import com.example.demo.repository.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	ModelRepository modelRepository;
	
	public List<Model> findAll() {
		return modelRepository.findAll();
	}
	
	public Model findById(Long id) {
		return modelRepository.findById(id).orElseGet(null);
	}

	public Model findByName(String modelName) {
		return modelRepository.findByName(modelName);
	}

}
