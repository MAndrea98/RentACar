package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Model;
import com.example.demo.repository.ModelRepository;

@Service
public class ModelService {

	@Autowired
	private ModelRepository modelRepository;
	
	public List<Model> findAll(){
		return modelRepository.findAll();
	}
}
