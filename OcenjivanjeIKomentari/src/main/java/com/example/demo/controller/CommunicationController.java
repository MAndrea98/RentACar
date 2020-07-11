package com.example.demo.controller;

import java.util.ArrayList;

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

import com.example.demo.model.Ad;
import com.example.demo.model.Request;
import com.example.demo.service.AdService;
import com.example.demo.service.RequestService;

@RefreshScope
@RestController
@RequestMapping(value = "/call")
@CrossOrigin("http://localhost:4200")
public class CommunicationController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private AdService adService;
	
	@PostMapping(value = "/addRequest")
	public ResponseEntity<String> addRequest(@RequestBody Request request) {
		System.out.println("##usao");
		requestService.save(request);
		return new ResponseEntity<String>("Uspeh", HttpStatus.OK);
	}
	
	@PutMapping(value = "/editRequest")
	public ResponseEntity<String> editRequest(@RequestBody Request request) {
		System.out.println("####" + request);
		Request r = requestService.findById(request.getId());
		r.setStatus(request.getStatus());
		requestService.save(r);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/adAds")
	public ResponseEntity<String> addAds(@RequestBody String adsIds) {
		String[] split = adsIds.split("=");
		String[] splitter = split[1].split("&");
		Request request = requestService.findById(Long.parseLong(split[0]));
		for (String s : splitter) {
			Ad a = adService.findById(Long.parseLong(s));
			if(a == null)
				System.out.println("null");
			a.setRequests(new ArrayList<Request>());
			a.getRequests().add(request);
			adService.save(a);
		}
		System.out.println("####" + request);
		return new ResponseEntity<String>("Prosao", HttpStatus.OK);
	}
	
	
	
}
