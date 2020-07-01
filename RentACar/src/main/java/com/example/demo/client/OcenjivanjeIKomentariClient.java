package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.CreateReviewRequest;
import com.example.consumingwebservice.CreateReviewResponse;
import com.example.consumingwebservice.DeleteReviewRequest;
import com.example.consumingwebservice.DeleteReviewResponse;
import com.example.consumingwebservice.EditReviewRequest;
import com.example.consumingwebservice.EditReviewResponse;
import com.example.consumingwebservice.ReviewDTOOIK;

public class OcenjivanjeIKomentariClient extends WebServiceGatewaySupport {
	private static final Logger log = LoggerFactory.getLogger(RazmenaPorukaClient.class);
	
	public CreateReviewResponse createReview(ReviewDTOOIK review) {
		CreateReviewRequest request= new CreateReviewRequest();
		request.setReview(review);
		
		log.info("Requesting create review status ");
		
		CreateReviewResponse response  = (CreateReviewResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8085/ws/reviews", request,
						 new SoapActionCallback("http://localhost:8085/api/OcenjivanjeIKomentari/createReviewRequest"));
		
		return response;
	}
	
	public EditReviewResponse editReview(ReviewDTOOIK review) {
		EditReviewRequest request = new EditReviewRequest();
		
		log.info("Requesting create review status ");
		
		EditReviewResponse response = (EditReviewResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8085/ws/reviews", request,
						 new SoapActionCallback("http://localhost:8085/api/OcenjivanjeIKomentari/editReviewRequest"));
		
		return response;
	}
	
	public DeleteReviewResponse deleteReview(Long id) {
		DeleteReviewRequest request = new DeleteReviewRequest();
		
		log.info("Requesting create review status ");
		
		DeleteReviewResponse response = (DeleteReviewResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8085/ws/reviews", request,
						 new SoapActionCallback("http://localhost:8085/api/OcenjivanjeIKomentari/deleteReviewRequest"));
		
		return response;
	}
	

}
