package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Report;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;
import com.example.demo.service.EndUserService;
import com.example.demo.service.RenterService;
import com.example.demo.service.ReportService;
import com.example.demo.service.RequestService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.UserModelService;

@RequestMapping("/review")
@CrossOrigin("http://localhost:4200")
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
	public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO) {
		UserModel renterUser = userModelService.findByUsername(reviewDTO.getRenterUsername());
		UserModel endUserUser = userModelService.findByUsername(reviewDTO.getEndUserUsername());
		Renter renter = renterService.findByIdUser(renterUser.getId());
		EndUser endUser = endUserService.findByIdUser(endUserUser.getId());
		Request request = requestService.findById(reviewDTO.getRequestID());
		List<Request> requests = requestService.findByParameters(endUser, RequestStatus.ENDED);
		Boolean found = false;
		for (Request r : requests) {
			if (r.getVehicles().get(0).getOwner().getId().equals(renter.getId()))
				found = true;
		}
		if (!found) {
			return new ResponseEntity<ReviewDTO>(HttpStatus.BAD_REQUEST); 
		}
		Review review = new Review();
		review.setEndUser(endUser);
		review.setContent(reviewDTO.getContent());
		review.setStars(reviewDTO.getStars());
		Review r = reviewService.save(review);
		
		Report report = new Report(request, review);
		reportService.save(report);
		
		return new ResponseEntity<ReviewDTO>(new ReviewDTO(r, request, endUserUser, renterUser),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<ReviewDTO>> getReview() {
		//UserModel user = userModelService.findById(LogedUser.getInstance().getUserId());
		
		UserModel user = userModelService.findById(3L);
		Renter renter = renterService.findByIdUser(user.getId());
		if (renter == null)
			return new ResponseEntity<List<ReviewDTO>>(HttpStatus.BAD_REQUEST);
		//System.out.println("##" + user.getUsername() + " " + renter.getReviews().size());
		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
		// TODO find error
		/*for (Review r : renter.getReviews()) {
			if (!r.isDeleted()) {
				UserModel endUser = userModelService.findById(r.getEndUser().getIdUser());
				reviewDTOs.add(new ReviewDTO(r, user.getUsername(), endUser.getUsername()));
			}
		}*/
		return new ResponseEntity<List<ReviewDTO>>(reviewDTOs, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ReviewDTO> editReview(@RequestBody Review review) {
		Review r = reviewService.findById(review.getId());
		r.setStars(review.getStars());
		r.setContent(review.getContent());
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
	
	@GetMapping(value = "/allReview")
	public ResponseEntity<List<ReviewDTO>> getAllReviews() {
		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
		for (Review r : reviewService.findAll()) {
			if (!r.isDeleted()) {
				UserModel endUser = userModelService.findById(r.getEndUser().getIdUser());
				UserModel renter = userModelService.findById(r.getAd().getVehicle().getOwner().getIdUser());
				reviewDTOs.add(new ReviewDTO(r, renter.getUsername(), endUser.getUsername()));
			}
		}
		return new ResponseEntity<List<ReviewDTO>>(reviewDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/acceptComment")
	public ResponseEntity<ReviewDTO> acceptComment(@RequestBody ReviewDTO reviewDTO) {
		Review review = reviewService.findById(reviewDTO.getId());
		review.setAccepted(true);
		Review r = reviewService.save(review);
		return new ResponseEntity<ReviewDTO>(new ReviewDTO(r), HttpStatus.OK);
	}
	
	@PutMapping("/declineComment")
	public ResponseEntity<String> declineComment(@RequestBody ReviewDTO reviewDTO) {
		Review review = reviewService.findById(reviewDTO.getId());
		review.setDeleted(true);
		reviewService.save(review);
		return new ResponseEntity<String>("Declined", HttpStatus.OK);
	}

}
