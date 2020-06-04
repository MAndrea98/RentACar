package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Model> findById(Long id){
		return modelRepository.findById(id);
	}
	public Model save(Model m) {
		return modelRepository.save(m);
	}
	
	public void delete(Model m) {
		modelRepository.delete(m);
	}
}
