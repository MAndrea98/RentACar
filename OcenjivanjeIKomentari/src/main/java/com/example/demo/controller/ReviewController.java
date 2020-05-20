package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Review;

@RequestMapping("/rating")
public class ReviewController {
	
	@PostMapping("/create")
	public ResponseEntity<Review> createReview() {
		return new ResponseEntity<Review>(new Review(),HttpStatus.OK);
	}

}
