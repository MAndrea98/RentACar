package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.AcceptCommentRequest;
import com.example.consumingwebservice.AcceptCommentResponse;
import com.example.consumingwebservice.DeclineCommentRequest;
import com.example.consumingwebservice.DeclineCommentResponse;
import com.example.consumingwebservice.ReviewDTOA;

public class AdministratorClient extends WebServiceGatewaySupport {
	private static final Logger log = LoggerFactory.getLogger(RazmenaPorukaClient.class);
	
	public AcceptCommentResponse acceptComment(ReviewDTOA review) {
		AcceptCommentRequest request = new AcceptCommentRequest();
		
		log.info("Requesting decline review status ");
		
		AcceptCommentResponse response  = (AcceptCommentResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8087/ws/administrator", request,
						 new SoapActionCallback("http://localhost:8087/api/Administrator/acceptCommentRequest"));
		 
		 return response;
	}
	
	public DeclineCommentResponse declineComment(ReviewDTOA review) {
		DeclineCommentRequest request = new DeclineCommentRequest();
		
		log.info("Requesting decline review status");
		
		DeclineCommentResponse response  = (DeclineCommentResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8087/ws/administrator", request,
						 new SoapActionCallback("http://localhost:8087/api/Administrator/declineCommentRequest"));
		 
		return response;
	}
}
