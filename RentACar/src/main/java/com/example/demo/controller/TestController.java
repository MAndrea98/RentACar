package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping
	public ResponseEntity<String> getSimpleResult() {
		return new ResponseEntity<String>("Rent a Car", HttpStatus.OK);
	}

}
