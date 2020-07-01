package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id) {
		Vehicle v = vehicleService.findOne(id);
		return new ResponseEntity<Vehicle>(v,HttpStatus.OK);
	}
	
	public ResponseEntity<List<VehicleDTO>> getMyVehicles() {
		return new ResponseEntity<List<VehicleDTO>>(HttpStatus.OK);
	}
}
