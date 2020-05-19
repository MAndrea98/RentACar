package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Value("${test}")
	private String test;
	
	@RequestMapping
	public ResponseEntity<String> getSimpleResult() {
		return new ResponseEntity<String>(test, HttpStatus.OK);
	}

}