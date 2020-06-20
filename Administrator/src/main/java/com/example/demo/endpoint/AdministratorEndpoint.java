package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.Review;
import com.example.demo.service.GasTypeService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.ModelService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.UserModelService;
import com.example.demo.service.VehicleClassService;
import com.example.demo.service.VehicleService;

import localhost._8087.api.administrator.AcceptCommentRequest;
import localhost._8087.api.administrator.AcceptCommentResponse;
import localhost._8087.api.administrator.DeclineCommentRequest;
import localhost._8087.api.administrator.DeclineCommentResponse;

@Endpoint
public class AdministratorEndpoint {
	
	private static final String NAMESPACE_URI = "http://localhost:8087/api/Administrator/";
	
	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleClassService vehicleClassService;
	
	@Autowired
	private ModelService modelService;
		
	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private GasTypeService gasTypeService;
	
	@Autowired
	private ReviewService reviewService;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "acceptCommentRequest")
	@ResponsePayload
	public AcceptCommentResponse acceptComment(@RequestPayload AcceptCommentRequest reviewDTO) {
		
		AcceptCommentResponse response = new AcceptCommentResponse();
		Review review = reviewService.findById(reviewDTO.getReview().getId());
		review.setAccepted(true);
		reviewService.save(review);
		response.setReview(reviewDTO.getReview());	
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "declineCommentRequest")
	@ResponsePayload
	public DeclineCommentResponse declineComment(@RequestPayload DeclineCommentRequest reviewDTO ) {
		DeclineCommentResponse response = new DeclineCommentResponse();
		Review review = reviewService.findById(reviewDTO.getReview().getId());
		reviewService.delete(review);
		response.setResponse("COMMENT DECLINED");
		return response;
	}

}
