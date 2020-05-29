package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CartDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.model.LogedUser;
import com.example.demo.model.Request;
import com.example.demo.model.Vehicle;
import com.example.demo.service.CartService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RenterService;
import com.example.demo.service.RequestService;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	@Autowired
	private CartService cartService;
	@Autowired
	private EndUserService endUserService;
	@Autowired
	private RequestService requestService;

	@GetMapping(value = "/addToCart/{id}")
	public ResponseEntity<CartDTO> addToCart(@PathVariable("id") Long id) {
		EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		if (endUser == null)
			return new ResponseEntity<CartDTO>(HttpStatus.BAD_REQUEST);
		
		Vehicle vehicle = vehicleService.findById(id);
		Cart cart = cartService.findByEndUserID(endUser.getId());
		cart.getVehicles().add(vehicle);
		Cart c = cartService.save(cart);
		
		return new ResponseEntity<CartDTO>(new CartDTO(c), HttpStatus.OK);
	}
	
	@PostMapping(value = "/sendSingleRequest")
	public ResponseEntity<RequestDTO> sendRequest(@RequestBody Vehicle vehicle) {
		EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		if (endUser == null)
			return new ResponseEntity<RequestDTO>(HttpStatus.BAD_REQUEST);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicle);
		Request request = new Request(vehicles, "PENDING", vehicle.getOwner(), endUser);
		Request r = requestService.save(request);
		return new ResponseEntity<RequestDTO>(new RequestDTO(r), HttpStatus.OK);
	}
	
	@PostMapping(value = "/sendBundle")
	public ResponseEntity<RequestDTO> sendBundle() {
		EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		if (endUser == null)
			return new ResponseEntity<RequestDTO>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<RequestDTO>(new RequestDTO(), HttpStatus.OK);
	}
}
