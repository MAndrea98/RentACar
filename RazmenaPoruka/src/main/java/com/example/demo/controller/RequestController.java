package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ad;
import com.example.demo.model.Request;
import com.example.demo.service.AdService;
import com.example.demo.service.RequestService;

@RefreshScope
@RestController
@RequestMapping(value = "/request")
@CrossOrigin("http://localhost:4200")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private AdService adService;
	
	@PostMapping(value = "/{adsIds}")
	public ResponseEntity<String> saveRequest(@RequestBody Request request, 
											  @PathVariable("adsIds") String adsIds) {
		String[] splitter = adsIds.split("&");
		for (String s : splitter) {
			Ad a = adService.findById(Long.parseLong(s));
			a.getRequests().add(request);
			adService.save(a);
		}
		requestService.save(request);
		return new ResponseEntity<String>("Uspesno", HttpStatus.OK);
	}
}
