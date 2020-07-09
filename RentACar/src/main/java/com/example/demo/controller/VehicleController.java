package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CartDTO;
import com.example.demo.dto.VehicleDTO;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.service.CartService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RequestService;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin("http://localhost:4200")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private RequestService requestService;
	
	// TODO find by Renter id
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Vehicle>> getAll() {
		List<Vehicle> ret = vehicleService.findAll();
		return new ResponseEntity<List<Vehicle>>(ret,HttpStatus.OK);
	}

	@RequestMapping(value="/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id) {
		Vehicle v = vehicleService.findOne(id);
		return new ResponseEntity<Vehicle>(v,HttpStatus.OK);
	}
	@GetMapping(value = "/addToCart/{id}")
	public ResponseEntity<CartDTO> addToCart(@PathVariable("id") Long id) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null) {
			return new ResponseEntity<CartDTO>(HttpStatus.BAD_REQUEST);
		}

		Vehicle vehicle = vehicleService.findById(id);
		Cart cart = cartService.findByEndUserID(endUser.getId());
		cart.getVehicles().add(vehicle);
		Cart c = cartService.save(cart);
		return new ResponseEntity<CartDTO>(new CartDTO(c), HttpStatus.OK);
	}

	@PostMapping(value = "/sendSingleRequest")
	public ResponseEntity<String> sendRequest(@RequestBody VehicleDTO vehicleDTO) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null)
			return new ResponseEntity<String>("You don't have permission to do this task.", HttpStatus.BAD_REQUEST);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle v = vehicleService.findById(vehicleDTO.getId());
		vehicles.add(v);
		Request request = new Request(vehicles, RequestStatus.PENDING, endUser);
		requestService.save(request);
		return new ResponseEntity<String>("The request has been successfully sent.", HttpStatus.OK);
	}

	@PostMapping(value = "/sendBundle")
	public ResponseEntity<String> sendBundle(@RequestBody List<VehicleDTO> vehicleDTOlist) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null)
			return new ResponseEntity<String>("You don't have permission to do this task.", HttpStatus.BAD_REQUEST);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle vFirst = vehicleService.findById(vehicleDTOlist.get(0).getId());
		Long idFirst = vFirst.getOwner().getIdUser();
		for (VehicleDTO vehicleDTO : vehicleDTOlist) {
			Vehicle v = vehicleService.findById(vehicleDTO.getId());
			if (!idFirst.equals(v.getOwner().getIdUser())) {
				return new ResponseEntity<String>("The owner of vehicles are not the same.", HttpStatus.BAD_REQUEST);
			}
			vehicles.add(v);
		}
		Request request = new Request(vehicles, RequestStatus.PENDING, endUser);
		requestService.save(request);
		return new ResponseEntity<String>("The requests have been successfully sent.", HttpStatus.OK);
	}
}
