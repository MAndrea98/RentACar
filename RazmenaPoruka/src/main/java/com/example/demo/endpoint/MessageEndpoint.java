package com.example.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.service.MessageService;

//import localhost._8089.api.razmenaporuka.Message;
//import localhost._8089.api.razmenaporuka.SendMessage;

@Endpoint
public class MessageEndpoint {
	private static final String NAMESPACE_URI = "http://localhost:8089/api/RazmenaPoruka/";
	
	MessageService messageService;
	
	//kreira poruku, sacuva je u bazi?
	//@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessage")
	//@ResponsePayload
	/*public SendMessage sendMessage(@RequestPayload Message m) {
		SendMessage sendMessage = new SendMessage();
		//messageService.save(m);
		sendMessage.setMessage(m);
		return sendMessage;
	}*/
}
