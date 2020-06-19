package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/test")
public class TestController {
  
	@RequestMapping
	public ResponseEntity<String> getSimpleResult() {
		return new ResponseEntity<String>("Administrator", HttpStatus.OK);

	}

	@GetMapping("/string")
	public ResponseEntity<String> getStringToFront(){
		return new ResponseEntity<String>("Ret String", HttpStatus.OK);
	}

}