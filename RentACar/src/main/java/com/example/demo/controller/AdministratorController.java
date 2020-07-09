package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.AcceptCommentResponse;
import com.example.consumingwebservice.DeclineCommentResponse;
import com.example.consumingwebservice.ReviewDTOA;
import com.example.demo.client.AdministratorClient;

@RestController(value = "/administrator")
@CrossOrigin("http://localhost:4200/")
public class AdministratorController {

	@Autowired
	AdministratorClient administratorClient;	
	
	@PutMapping
	public AcceptCommentResponse acceptCommentSOAP(@RequestBody ReviewDTOA request) {
		return administratorClient.acceptComment(request);
	}
	
	@DeleteMapping
	public DeclineCommentResponse declineCommentSOAP(@RequestBody ReviewDTOA request) {
		return administratorClient.declineComment(request);
	}
}
