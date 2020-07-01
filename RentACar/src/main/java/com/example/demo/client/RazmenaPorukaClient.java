package com.example.demo.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.consumingwebservice.DeleteMessageRequest;
import com.example.consumingwebservice.DeleteMessageResponse;
import com.example.consumingwebservice.EditMessageRequest;
import com.example.consumingwebservice.EditMessageResponse;
import com.example.consumingwebservice.GetAllMessageResponse;
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
				
		 log.info("Requesting send message status ");
		 
		 SendMessageResponse response  = (SendMessageResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8089/ws/messages", request,
						 new SoapActionCallback("http://localhost:8089/api/RazmenaPoruka/sendMessageRequest"));
		 
		 return response;
	}
	
	public EditMessageResponse editMessage(MessageRP m) {
		EditMessageRequest request = new EditMessageRequest();
		request.setMessage(m);
		
		log.info("Requesting edit message status ");
		
		 EditMessageResponse response  = (EditMessageResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8089/ws/messages", request,
						 new SoapActionCallback("http://localhost:8089/api/RazmenaPoruka/editMessageRequest"));
		 
		 return response;
	}
	
	public DeleteMessageResponse deleteMessage(Long id) {
		DeleteMessageRequest request = new DeleteMessageRequest();
		request.setMessageId(id);
		
		log.info("Requesting delete message status ");
		
		DeleteMessageResponse response  = (DeleteMessageResponse) getWebServiceTemplate()
				 .marshalSendAndReceive("http://localhost:8089/ws/messages", request,
						 new SoapActionCallback("http://localhost:8089/api/RazmenaPoruka/deleteMessageRequest"));
		 
		 return response;
		
	}
	
	public GetAllMessageResponse getAllMessages() {		
		log.info("Requesting all messages ");
		
		GetAllMessageResponse response = (GetAllMessageResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8089/ws/messages", null,
						 new SoapActionCallback("http://localhost:8089/api/RazmenaPoruka/deleteMessageRequest"));
		
		return response;
	}
	
	
}
