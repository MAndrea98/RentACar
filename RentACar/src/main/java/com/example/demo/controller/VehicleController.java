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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.VehicleDTO;
import com.example.demo.model.Ad;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.service.AdService;
import com.example.demo.service.CartService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RenterService;
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
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private RenterService renterService;

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

		Ad ad = adService.findById(id);
		Cart cart = cartService.findByEndUserID(endUser.getId());
		cart.getAds().add(ad);
		Cart c = cartService.save(cart);
		return new ResponseEntity<CartDTO>(new CartDTO(c), HttpStatus.OK);
	}

	@PostMapping(value = "/sendSingleRequest")
	public ResponseEntity<String> sendRequest(@RequestBody Long idAds) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null)
			return new ResponseEntity<String>("You don't have permission to do this task.", HttpStatus.BAD_REQUEST);
		
		List<Ad> ads = new ArrayList<Ad>();
		Ad ad = adService.findById(idAds);
		ads.add(ad);
		Request request = new Request(ads, RequestStatus.PENDING, endUser);
		requestService.save(request);
		Cart cart = cartService.findByEndUserID(endUser.getId());
		for (int i = 0; i < cart.getAds().size(); i++) {
			if (cart.getAds().get(i).getId().equals(idAds)) {
				Ad a = cart.getAds().get(i);
				cart.getAds().remove(cart.getAds().get(i));
				a.getCarts().remove(cart);
				a.getRequests().add(request);
				adService.save(a);
			}
		}
		cartService.save(cart);
		return new ResponseEntity<String>("The request has been successfully sent.", HttpStatus.OK);
	}

	@PostMapping(value = "/sendBundle")
	public ResponseEntity<String> sendBundle(@RequestBody List<AdDTO> adDTOs) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null)
			return new ResponseEntity<String>("You don't have permission to do this task.", HttpStatus.BAD_REQUEST);
		List<Ad> ads = new ArrayList<Ad>();
		Ad adFirst = adService.findById(adDTOs.get(0).getId());
		Long idFirst = adFirst.getVehicle().getOwner().getIdUser();
		for (AdDTO adDTO : adDTOs) {
			Ad a = adService.findById(adDTO.getId());
			if (!idFirst.equals(a.getVehicle().getOwner().getIdUser())) {
				return new ResponseEntity<String>("The owner of vehicles are not the same.", HttpStatus.BAD_REQUEST);
			}
			ads.add(a);
		}
		Request request = new Request(ads, RequestStatus.PENDING, endUser);
		requestService.save(request);
		Cart cart = cartService.findByEndUserID(endUser.getId());
		for (int i = 0; i < cart.getAds().size(); i++) {
			for (AdDTO a : adDTOs) {
				if (cart.getAds().get(i).getId().equals(a.getId())) {
					Ad ad = cart.getAds().get(i);
					cart.getAds().remove(cart.getAds().get(i));
					ad.getCarts().remove(cart);
					ad.getRequests().add(request);
					adService.save(ad);
				}
			}
		}
		cartService.save(cart);
		return new ResponseEntity<String>("The requests have been successfully sent.", HttpStatus.OK);
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
