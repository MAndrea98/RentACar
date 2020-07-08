package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Request;
import com.example.demo.service.RequestService;

@RefreshScope
@RestController
@RequestMapping(value = "/call")
@CrossOrigin
public class CommunicationController {

	@Autowired
	private RequestService requestService;
	
	@PostMapping(value = "/addRequest")
	public ResponseEntity<String> addRequest(@RequestBody Request request) {
		System.out.println("####" + request);
		requestService.save(request);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/editRequest")
	public ResponseEntity<String> editRequest(@RequestBody Request request) {
		System.out.println("####" + request);
		Request r = requestService.findById(request.getId());
		r.setStatus(request.getStatus());
		requestService.save(r);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
