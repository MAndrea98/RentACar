package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RequestDTO;
import com.example.demo.model.Ad;
import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RenterService;
import com.example.demo.service.RequestService;

@RestController
@RequestMapping(value = "/request")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private RenterService renterService;
	
	@Autowired
	private EndUserService endUserService;
	
	@GetMapping
	public ResponseEntity<List<RequestDTO>> allMyRequests() {
		Renter renter = renterService.findById(1L);
		List<Request> requests = requestService.findAll();

		List<RequestDTO> requestDTOs = new ArrayList<RequestDTO>();
		for (int i = 0; i < requests.size(); i++) {
			Boolean ok = false;
			System.out.println("size: " + requests.get(i).getAds().size());
			for (Ad a : requests.get(i).getAds()) {
				System.out.println("##" + a.getVehicle().getOwner().getId());
				if (a.getVehicle().getOwner().getId().equals(renter.getId()))
					ok = true;
			}
			System.out.println("##" + ok);
			if (ok) {
				if (requests.get(i).getStatus().equals(RequestStatus.PENDING)) {
					requestDTOs.add(new RequestDTO(requests.get(i)));
				}
			}
		}
		System.out.println(requestDTOs.size());
		return new ResponseEntity<List<RequestDTO>>(requestDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/endUser")
	public ResponseEntity<List<RequestDTO>> endUserAllrequests() {
		EndUser endUser = endUserService.findByIdUser(1L);
		List<Request> requests = requestService.findByEndUser(endUser);
		List<RequestDTO> requestDTOs = new ArrayList<RequestDTO>();
		for (Request r : requests) {
			requestDTOs.add(new RequestDTO(r));
		}
		return new ResponseEntity<List<RequestDTO>>(requestDTOs, HttpStatus.OK);
	}
}
