package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	public Optional<Vehicle> findById(Long id){
		return vehicleRepository.findById(id);
	}
	
	public Vehicle save(Vehicle v) {
		return vehicleRepository.save(v);
	}
	
	public void delete(Vehicle v) {
		vehicleRepository.delete(v);
	}
}
