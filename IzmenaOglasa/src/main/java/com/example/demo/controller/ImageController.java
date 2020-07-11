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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleImage;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping(value = "/images")
@CrossOrigin
public class ImageController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping(value = "/{vehicle_id}")
	public ResponseEntity<List<VehicleImage>> getImages(@PathVariable("vehicle_id") Long id) {
		Vehicle vehicle = vehicleService.findById(id);
		List<VehicleImage> images = new ArrayList<VehicleImage>();
		for (VehicleImage vi : vehicle.getImages()) {
			images.add(vi);
		}
		return new ResponseEntity<List<VehicleImage>>(images, HttpStatus.OK);
	}
}
