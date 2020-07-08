package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.EndUser;
import com.example.demo.model.Report;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;
import com.example.demo.service.EndUserService;
import com.example.demo.service.ReportService;
import com.example.demo.service.RequestService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.UserModelService;

@RefreshScope
@RequestMapping("/review")
@RestController
@CrossOrigin("http://localhost:4200")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
		UserModel renterUser = userModelService.findByUsername(reviewDTO.getRenterUsername());
		UserModel endUserUser = userModelService.findByUsername(reviewDTO.getEndUserUsername());
		EndUser endUser = endUserService.findByUserId(endUserUser.getId());
		Request request = requestService.findById(reviewDTO.getRequestID());
		
		if (!request.getStatus().equals(RequestStatus.ENDED)) {
			System.out.println("Usao");
			return new ResponseEntity<ReviewDTO>(HttpStatus.BAD_REQUEST);
		}
		
		Review review = new Review();
		review.setEndUser(endUser);
		review.setContent(reviewDTO.getContent());
		review.setStars(reviewDTO.getStars());
		Review r = reviewService.save(review);
		String s = review.toString();
		System.out.println(s);
		
		Report report = new Report(request, review);
		reportService.save(report);
		String url = "http://localhost:8087/call";
        System.out.println("URL: " + url);
        restTemplate.put(url, s);
		
		return new ResponseEntity<ReviewDTO>(new ReviewDTO(r, request, endUserUser, renterUser),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ReviewDTO> editReview(@RequestBody ReviewDTO reviewDTO) {
		Review r = reviewService.findById(reviewDTO.getId());
		r.setStars(reviewDTO.getStars());
		r.setContent(reviewDTO.getContent());
		Review rev = reviewService.save(r);
		return new ResponseEntity<ReviewDTO>(new ReviewDTO(rev), HttpStatus.OK);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable("id") Long id) {
		Review review = reviewService.findById(id);
		review.setDeleted(true);
		reviewService.save(review);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

}
