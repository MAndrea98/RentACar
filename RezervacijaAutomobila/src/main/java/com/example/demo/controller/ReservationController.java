package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
	
	
	@PostMapping("/createSingle")
	public ResponseEntity<String> createSingleRequest() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/createBundle")
	public ResponseEntity<String> createBundleRequest() {
		return new ResponseEntity<String>(HttpStatus.OK);
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
