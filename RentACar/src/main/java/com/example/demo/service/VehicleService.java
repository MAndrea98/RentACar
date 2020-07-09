package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Model;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle findOne(Long id) {
		return vehicleRepository.findById(id).orElseGet(null);
	}

	public Vehicle findById(Long id) {
		return vehicleRepository.findById(id).orElse(null);

	}
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicle findByModel(Model m) {
		return vehicleRepository.findByModel(m);
	}

}
