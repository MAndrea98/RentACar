package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GasType;
import com.example.demo.repository.GasTypeRepository;

@Service
public class GasTypeService {

	@Autowired
	private GasTypeRepository gasTypeRepository;
	
	public List<GasType> findAll(){
		return gasTypeRepository.findAll();
	}
	
	public GasType save(GasType g) {
		return gasTypeRepository.save(g);
	}
	
	public Optional<GasType> findById(Long id){
		return gasTypeRepository.findById(id);
	}
	public void delete(GasType g) {
		gasTypeRepository.delete(g);
	}
	
	public void flush() {
		gasTypeRepository.flush();
	}
}
