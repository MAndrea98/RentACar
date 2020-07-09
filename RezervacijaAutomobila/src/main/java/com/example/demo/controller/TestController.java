package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RefreshScope
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@RequestMapping
	public ResponseEntity<String> getSimpleResult() {
		return new ResponseEntity<String>("Rezervacija automobila", HttpStatus.OK);
	}
	
	@GetMapping(value = "/call")
	public ResponseEntity<String> callOtherMicroservice() {
		String url = "http://localhost:8080/api/razmena-poruka/test";
        System.out.println("URL" + url);
        String emp = restTemplate.getForObject(url, String.class);
        System.out.println("RESPONSE " + emp);
		return new ResponseEntity<String>(emp, HttpStatus.OK);
	}

}
