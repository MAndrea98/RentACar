package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VehicleClass;
import com.example.demo.repository.VehicleClassRepository;

@Service
public class VehicleClassService {

	@Autowired
	private VehicleClassRepository vehicleClassRepository;
	
	public List<VehicleClass> findAll(){
		return vehicleClassRepository.findAll();
	}
	
	public Optional<VehicleClass> findById(Long id){
		return vehicleClassRepository.findById(id);
	}
	
	public VehicleClass save(VehicleClass v) {
		return vehicleClassRepository.save(v);
	}
	
	public void delete(VehicleClass v) {
		vehicleClassRepository.delete(v);
	}
	
	public void flush() {
		vehicleClassRepository.flush();
	}
}
