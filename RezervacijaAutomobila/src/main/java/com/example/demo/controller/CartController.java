package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleClass;
import com.example.demo.service.CartService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	public ResponseEntity<List<VehicleDTO>> myCart() {
		EndUser endUser = endUserService.findByIdUser(1L);
		Cart cart =  cartService.findByEndUserID(endUser.getId());
		System.out.println("####" + cart.getEndUserID() + "####" + cart.getVehicles().size());
		List<VehicleDTO> vehicleDTOs = new ArrayList<VehicleDTO>();
		for (Vehicle v : cart.getVehicles()) {
			vehicleDTOs.add(new VehicleDTO(v));
		}
		System.out.println("####" + vehicleDTOs.size());
		return new ResponseEntity<List<VehicleDTO>>(vehicleDTOs, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> removeFromCart(@PathVariable("id") Long id) {
		EndUser endUser = endUserService.findByIdUser(1L);
		Cart cart =  cartService.findByEndUserID(endUser.getId());
		System.out.println("####" + cart.getEndUserID() + "####" + cart.getVehicles().size());
		for (int i = 0 ; i < cart.getVehicles().size(); i++) {
			if (cart.getVehicles().get(i).getId().equals(id)) {
				Vehicle v = cart.getVehicles().get(i);
				cart.getVehicles().remove(cart.getVehicles().get(i));
				v.getCarts().remove(cart);
				vehicleService.save(v);
			}
		}
		Cart c = cartService.save(cart);
		System.out.println("####" + c.getVehicles().size() + "####" + cart.getVehicles().size());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
