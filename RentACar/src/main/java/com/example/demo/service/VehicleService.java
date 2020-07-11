package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Renter;
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

	public List<Vehicle> findByOwner(Renter owner) {
		return vehicleRepository.findByOwner(owner);
	}

}
