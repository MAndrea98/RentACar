package com.example.demo.endpoint;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.dto.MessageDTO;
import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.UserModel;
import com.example.demo.model.Message;
import com.example.demo.service.EndUserService;
import com.example.demo.service.MessageService;
import com.example.demo.service.RenterService;
import com.example.demo.service.RequestService;
import com.example.demo.service.UserModelService;

import localhost._8089.api.razmenaporuka.SendMessageRequest;
import localhost._8089.api.razmenaporuka.SendMessageResponse;

@Endpoint
public class MessageEndpoint {
	private static final String NAMESPACE_URI = "http://localhost:8089/api/RazmenaPoruka/";
	
	@Autowired
	UserModelService userModelService;
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	RenterService renterService;
	
	@Autowired
	EndUserService endUserService;
	
	@Autowired
	RequestService requestService;
	
	//kreira poruku, sacuva je u bazi?
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessage")
	@ResponsePayload
	public SendMessageResponse sendMessage(@RequestPayload SendMessageRequest messageDTO) {
		SendMessageResponse response = new SendMessageResponse();

		
		UserModel sender = userModelService.findById(1L);
		UserModel reciever = userModelService.findByUsername(messageDTO.getMessage().getReciever().getUsername());
		Renter renter = renterService.findByIdUser(sender.getId());
		EndUser endUser = endUserService.findByIdUser(reciever.getId());
		if (renter == null && endUser == null) {
			renter = renterService.findByIdUser(reciever.getId());
			endUser = endUserService.findByIdUser(sender.getId());
			if (renter == null && endUser == null) {
				System.out.println("####1");
				response.setResponse("BAD REQUEST");
				return response;
			}
		}
		
		Request request = requestService.findByParameters(renter, endUser, "RESERVED");
		if (request == null) {
			System.out.println("####2");
			response.setResponse("BAD REQUEST");
			return response;
		}
		Message message = new Message(sender, reciever, messageDTO.getMessage().getSubject(), messageDTO.getMessage().getContent(), Calendar.getInstance());
		Message m = messageService.save(message);
		
		return response;
	}
}
