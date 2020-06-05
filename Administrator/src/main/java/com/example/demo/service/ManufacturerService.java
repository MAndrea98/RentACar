package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	public List<Manufacturer> findAll(){
		return manufacturerRepository.findAll();
	}
	
	public Manufacturer save(Manufacturer m) {
		return manufacturerRepository.save(m);
	}
	
	public Optional<Manufacturer> findById(Long id){
		return manufacturerRepository.findById(id);
	}
	
	public void delete(Manufacturer m) {
		manufacturerRepository.delete(m);
	}
}
