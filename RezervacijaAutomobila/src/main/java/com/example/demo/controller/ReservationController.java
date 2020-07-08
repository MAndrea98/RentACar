package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AdDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.RequestDTO;
import com.example.demo.model.Ad;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.service.AdService;
import com.example.demo.service.CartService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RequestService;

@RefreshScope
@RestController
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {
	
	//TODO: Potrebno je odraditi prosirivanje baze na ceo i agentsku aplikaciju
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/addToCart/{id}")
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
	
	@PostMapping("/createSingle")
	public ResponseEntity<String> createSingleRequest(@RequestBody Long idAds) {
		//EndUser endUser = endUserService.findByIdUser(LogedUser.getInstance().getUserId());
		System.out.println("#####usao");
		EndUser endUser = endUserService.findByIdUser(1L);
		if (endUser == null)
			return new ResponseEntity<String>("You don't have permission to do this task.", HttpStatus.BAD_REQUEST);
		List<Ad> ads = new ArrayList<Ad>();
		Ad ad = adService.findById(idAds);
		ads.add(ad);
		System.out.println("### save, size: " + ads.size());
		Request request = new Request(ads, RequestStatus.PENDING, endUser);
		Request r = requestService.save(request);
		System.out.println("### save, ads size: " + r.getAds().size());
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
	
	@PostMapping("/createBundle")
	public ResponseEntity<String> createBundleRequest(@RequestBody List<AdDTO> adDTOs) {
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
	
	@PutMapping("/accept")
	public ResponseEntity<String> acceptRequest(@RequestBody Long requestID) {
		Request request = requestService.findById(requestID);
		request.setStatus(RequestStatus.RESERVED);
		requestService.save(request);
		
		Request requestForMessages = new Request();
		requestForMessages.setId(request.getId());
		requestForMessages.setEndUser(request.getEndUser());
		requestForMessages.setStatus(request.getStatus());
		requestForMessages.setAds(new ArrayList<Ad>());
		String url = "http://localhost:8089/request/";
		
		List<Request> allRequests = requestService.findAll();
		for (Request r : allRequests) {
			for (Ad a : request.getAds()) {
				if (r.getId().equals(a.getId())) {
					r.setStatus(RequestStatus.DENIED);
					requestService.save(r);
				}
				url += a.getId() + "&";
			}
		}
		System.out.println(request.getAds());
        System.out.println("URL" + url);
        ResponseEntity<String> emp = restTemplate.postForEntity(url, requestForMessages, String.class);
        System.out.println("RESPONSE " + emp);
        
        String url1 = "http://localhost:8085/call/addRequest";
        ResponseEntity<String> emp1 = restTemplate.postForEntity(url1, request, String.class);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/decline")
	public ResponseEntity<String> declineRequest(@RequestBody Long requestID) {
		Request request = requestService.findById(requestID);
		request.setStatus(RequestStatus.DENIED);
		requestService.save(request);
		String url = "http://localhost:8089/request";
        System.out.println("URL" + url);
        restTemplate.put(url, request);
        String url1 = "http://localhost:8085/call/editRequest";
        restTemplate.put(url1, request);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/cancel")
	public ResponseEntity<String> cancelRequest(@RequestBody RequestDTO requestDTO) {
		Request request = requestService.findById(requestDTO.getId());
		request.setStatus(RequestStatus.CANCELED);
		requestService.save(request);
		String url = "http://localhost:8089/request";
        System.out.println("URL" + url);
        restTemplate.put(url, request);
        String url1 = "http://localhost:8085/call/editRequest";
        restTemplate.put(url1, request);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/endRenting")
	public ResponseEntity<String> endRenting(@RequestBody RequestDTO requestDTO) {
		Request request = requestService.findById(requestDTO.getId());
		request.setStatus(RequestStatus.ENDED);
		requestService.save(request);
		String url = "http://localhost:8089/request";
        System.out.println("URL" + url);
        restTemplate.put(url, request);
        String url1 = "http://localhost:8085/call/editRequest";
        restTemplate.put(url1, request);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	

}



