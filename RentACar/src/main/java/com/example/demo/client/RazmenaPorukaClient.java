package com.example.demo.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.MessageRP;
import com.example.consumingwebservice.SendMessageRequest;
import com.example.consumingwebservice.SendMessageResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RazmenaPorukaClient extends WebServiceGatewaySupport  {
	private static final Logger log = LoggerFactory.getLogger(RazmenaPorukaClient.class);
	
	public SendMessageResponse sendMessage(MessageRP m) {
		SendMessageRequest request = new SendMessageRequest();
		request.setMessage(m);
				
		 log.info("Requesting message status ");
		 
		 SendMessageResponse response  = (SendMessageResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8089/ws/messages", request,
						 new SoapActionCallback("http://localhost:8089/api/RazmenaPoruka/sendMessageRequest"));
		 
		 return response;
	}
	
}
