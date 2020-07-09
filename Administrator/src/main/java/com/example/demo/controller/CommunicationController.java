package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.Ad;
import com.example.demo.model.EndUser;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;
import com.example.demo.service.AdService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.UserModelService;

@RefreshScope
@RestController
@RequestMapping(value="/call")
@CrossOrigin
public class CommunicationController {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private AdService adService;
	
	@PutMapping(value="/addReview/{adId}")
	public ResponseEntity<String> addReview(@RequestBody ReviewDTO reviewDTO, @PathVariable("adId") Long id) {
		UserModel endUserUser = userModelService.findByUsername(reviewDTO.getEndUserUsername()).get();
		EndUser endUser = endUserService.findByIdUser(endUserUser.getId()).get();
		Ad ad = adService.findById(id);
		Review review = new Review();
		review.setEndUser(endUser);
		review.setContent(reviewDTO.getContent());
		review.setStars(reviewDTO.getStars());
		review.setAd(ad);
		ad.getListOfReviews().add(review);
		reviewService.save(review);
		adService.save(ad);
		System.out.println(review);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Prosao", HttpStatus.OK);
	}
}
