package com.example.demo.service;

import java.util.List;

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
}
