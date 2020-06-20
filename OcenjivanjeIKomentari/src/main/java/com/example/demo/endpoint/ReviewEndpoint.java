package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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

import localhost._8085.api.ocenjivanjeikomentari.CreateReviewRequest;
import localhost._8085.api.ocenjivanjeikomentari.CreateReviewResponse;
import localhost._8085.api.ocenjivanjeikomentari.DeleteReviewRequest;
import localhost._8085.api.ocenjivanjeikomentari.DeleteReviewResponse;
import localhost._8085.api.ocenjivanjeikomentari.EditReviewRequest;
import localhost._8085.api.ocenjivanjeikomentari.EditReviewResponse;

@Endpoint
public class ReviewEndpoint {
	
	private static final String NAMESPACE_URI = "http://localhost:8085/api/OcenjivanjeIKomentari/";
	
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
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createReviewRequest")
	@ResponsePayload
	public CreateReviewResponse createReview(@RequestPayload CreateReviewRequest reviewDTO) {
		
		CreateReviewResponse response = new CreateReviewResponse();
		System.out.println("USAO");
		
		UserModel renterUser = userModelService.findByUsername(reviewDTO.getReview().getRenterUsername());
		UserModel endUserUser = userModelService.findByUsername(reviewDTO.getReview().getEndUserUsername());
		Renter renter = renterService.findByUserId(renterUser.getId());
		EndUser endUser = endUserService.findByUserId(endUserUser.getId());
		

		System.out.println(renter.getId() + " " + endUser.getIdUser());
		Request request = requestService.findByParameters(renter, endUser, "ENDED");
		// TODO namestiti findByParameters da ne vraca null
		
		  if (request == null) {
			  System.out.println("REQUEST IS NULL");
			  return null; 
			  
		  }
		 
		Review review = new Review();
		review.setRenter(renter);
		review.setEndUser(endUser);
		review.setContent(reviewDTO.getReview().getContent());
		review.setStars(reviewDTO.getReview().getStars());
		reviewService.save(review);
		
		Report report = new Report(request, review);
		reportService.save(report);
		
		response.setReview(reviewDTO.getReview());
		return response;
		
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "editReviewRequest")
	@ResponsePayload
	public EditReviewResponse editReview(@RequestPayload EditReviewRequest reviewDTO) {
		EditReviewResponse response = new EditReviewResponse();
		
		try {
			Review r = reviewService.findById(reviewDTO.getReview().getId());
			r.setStars(reviewDTO.getReview().getStars());
			r.setContent(reviewDTO.getReview().getContent());
			reviewService.save(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		response.setReview(reviewDTO.getReview());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteReviewRequest")
	@ResponsePayload
	public DeleteReviewResponse deleteReview(@RequestPayload DeleteReviewRequest request) {
		DeleteReviewResponse response = new DeleteReviewResponse();
		Review review = reviewService.findById(request.getId());
		review.setDeleted(true);
		reviewService.save(review);
		
		response.setResponse("REVIEW DELETED");
		return response;
		
	}

}
