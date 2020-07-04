package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {
	
	//TODO: Potrebno je odraditi bundle na frontu i prosirivanje baze na ceo i agentsku aplikaciju
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private RequestService requestService;
	
	
	@GetMapping("/addToCart/{id}")
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
	
	@PostMapping("/createSingle")
	public ResponseEntity<String> createSingleRequest(@RequestBody Long idVehicle) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		System.out.println("#####usao");
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null)
			return new ResponseEntity<String>("You don't have permission to do this task.", HttpStatus.BAD_REQUEST);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		Vehicle v = vehicleService.findById(idVehicle);
		vehicles.add(v);
		Request request = new Request(vehicles, RequestStatus.PENDING, endUser);
		requestService.save(request);
		Cart cart = cartService.findByEndUserID(endUser.getId());
		System.out.println("####" + cart.getEndUserID() + "####" + cart.getVehicles().size());
		for (int i = 0; i < cart.getVehicles().size(); i++) {
			if (cart.getVehicles().get(i).getId().equals(idVehicle)) {
				cart.getVehicles().remove(i);
			}
		}
		Cart c = cartService.save(cart);
		System.out.println("####" + cart.getEndUserID() + "####" + cart.getVehicles().size());
		System.out.println("#####izasao");
		return new ResponseEntity<String>("The request has been successfully sent.", HttpStatus.OK);
	}
	
	@PostMapping("/createBundle")
	public ResponseEntity<String> createBundleRequest(@RequestBody List<VehicleDTO> vehicleDTOlist) {
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
	
	@PutMapping("/accept")
	public ResponseEntity<String> acceptRequest() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/decline")
	public ResponseEntity<String> declineRequest() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/cancel")
	public ResponseEntity<String> cancelRequest() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	

}
