package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;

@RefreshScope
@RestController
@RequestMapping(value="/call")
@CrossOrigin
public class CommunicationController {

	@Autowired
	private ReviewService reviewService;
	
	@PutMapping
	public ResponseEntity<String> addReview(@RequestBody String s) {
		System.out.println(s);
		/*System.out.println("####" + review);
		Review r = reviewService.save(review);*/
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Prosao", HttpStatus.OK);
	}
}
