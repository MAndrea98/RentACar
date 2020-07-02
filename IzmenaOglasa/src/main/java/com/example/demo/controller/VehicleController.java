package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.model.Renter;
import com.example.demo.model.Vehicle;
import com.example.demo.service.RenterService;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin("http://localhost:4200")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private RenterService renterService;

	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id) {
		Vehicle v = vehicleService.findOne(id);
		return new ResponseEntity<Vehicle>(v,HttpStatus.OK);
	}
	
	@GetMapping(value = "/myVehicles")
	public ResponseEntity<List<VehicleDTO>> getMyVehicles() {
		Renter owner = renterService.findByIdUser(2L);
		List<Vehicle> vehicles = vehicleService.findByOwner(owner);
		List<VehicleDTO> vehicleDTOs = new ArrayList<VehicleDTO>();
		for(Vehicle v : vehicles) {
			vehicleDTOs.add(new VehicleDTO(v));
		} 
		return new ResponseEntity<List<VehicleDTO>>(vehicleDTOs, HttpStatus.OK);
	}
	
}
