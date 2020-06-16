package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Report;
import com.example.demo.model.Request;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RenterService;
import com.example.demo.service.ReportService;
import com.example.demo.service.RequestService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.UserModelService;

@RequestMapping("/review")
@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private RenterService renterService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private ReportService reportService;
	
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDTO) {
		UserModel renterUser = userModelService.findByUsername(reviewDTO.getRenterUsername());
		UserModel endUserUser = userModelService.findByUsername(reviewDTO.getEndUserUsername());
		Renter renter = renterService.findByUserId(renterUser.getId());
		EndUser endUser = endUserService.findByUserId(endUserUser.getId());
		Request request = requestService.findByParameters(renter, endUser, "ENDED");
		if (request == null)
			return new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);
		Review review = new Review();
		review.setRenter(renter);
		review.setEndUser(endUser);
		review.setContent(reviewDTO.getContent());
		review.setStars(reviewDTO.getStars());
		reviewService.save(review);
		
		Report report = new Report(request, review);
		reportService.save(report);
		
		return new ResponseEntity<Review>(new Review(),HttpStatus.OK);
	}

}
