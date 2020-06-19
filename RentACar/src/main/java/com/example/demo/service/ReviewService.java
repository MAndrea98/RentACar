package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private static ReviewRepository reviewRepository;

	public Review save(Review review) {
		return reviewRepository.save(review);
	}

	public Review findById(Long id) {
		return reviewRepository.findById(id).orElse(null);
	}

	public void delete(Review review) {
		reviewRepository.deleteById(review.getId());
	}

	public static List<Review> findAll() {
		return reviewRepository.findAll();
	}




}
