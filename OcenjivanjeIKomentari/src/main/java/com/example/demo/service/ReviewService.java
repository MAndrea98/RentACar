package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public Review save(Review review) {
		return reviewRepository.save(review);
	}
	
	public Review findById(Long id) {
		return reviewRepository.findById(id).orElse(null);
	}
	
	
}
