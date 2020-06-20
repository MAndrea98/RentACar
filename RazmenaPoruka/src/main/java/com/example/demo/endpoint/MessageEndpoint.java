package com.example.demo.endpoint;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
import com.example.demo.model.UserType;
import com.example.demo.model.Message;
import com.example.demo.service.EndUserService;
import com.example.demo.service.MessageService;
import com.example.demo.service.RenterService;
import com.example.demo.service.RequestService;
import com.example.demo.service.UserModelService;

import localhost._8089.api.razmenaporuka.GetAllMessageResponse;
import localhost._8089.api.razmenaporuka.SendMessageRequest;
import localhost._8089.api.razmenaporuka.SendMessageResponse;
import localhost._8089.api.razmenaporuka.MessageXML;
import localhost._8089.api.razmenaporuka.UserModelXML;
import localhost._8089.api.razmenaporuka.UserTypeXML;

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
	
	//kreira poruku, sacuva je u bazi i vrati na agentsku poruku da je uspelo
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
	
	public GetAllMessageResponse getAllMessages() {
		UserModel user = userModelService.findById(3L);
		GetAllMessageResponse response = new GetAllMessageResponse();
		for (Message m : user.getInbox())
			if (!m.isDeleted()) {
				MessageXML msg= new MessageXML();
				UserModelXML receiver = new UserModelXML();
				UserTypeXML ulogaRec;
				UserTypeXML ulogaSen;
				UserModelXML sender = new UserModelXML();
				
				if(user.getUloga() == UserType.ADMIN) {
					ulogaRec = UserTypeXML.ADMIN;
				} else if (user.getUloga() == UserType.ENDUSER) {
					ulogaRec = UserTypeXML.ENDUSER;
				} else if (user.getUloga() == UserType.RENTER) {
					ulogaRec = UserTypeXML.RENTER;
				} else {
					ulogaRec = UserTypeXML.ENDUSER;
				}
				
				if(user.getUloga() == UserType.ADMIN) {
					ulogaSen = UserTypeXML.ADMIN;
				} else if (user.getUloga() == UserType.ENDUSER) {
					ulogaSen = UserTypeXML.ENDUSER;
				} else if (user.getUloga() == UserType.RENTER) {
					ulogaSen = UserTypeXML.RENTER;
				} else {
					ulogaSen = UserTypeXML.ENDUSER;
				}
				receiver.setPassword(user.getPassword());
				receiver.setUsername(user.getUsername());
				receiver.setUloga(ulogaRec);
				
				sender.setPassword(user.getPassword());
				sender.setUsername(user.getUsername());
				sender.setUloga(ulogaSen);
				
				msg.setContent(m.getContent());
				msg.setDate(toXMLCalendar(m.getDate()));
				msg.setReciever(receiver);
				msg.setSender(sender);
				msg.setSubject(m.getSubject());
				
				
				response.getMessages().add(msg);
			}
		return null;
	}
	
	public static XMLGregorianCalendar toXMLCalendar(Calendar calandar ){
	    XMLGregorianCalendar xmlCalendar = null;
	    try {
	        DatatypeFactory dtf = DatatypeFactory.newInstance();
	        xmlCalendar = dtf.newXMLGregorianCalendar();
	        xmlCalendar.setYear(calandar.get(Calendar.YEAR));
	        xmlCalendar.setDay(calandar.get(Calendar.DAY_OF_MONTH));
	        xmlCalendar.setMonth(calandar.get(Calendar.MONTH)+ 1);
	        xmlCalendar.setHour(calandar.get(Calendar.HOUR_OF_DAY));
	        xmlCalendar.setMinute(calandar.get(Calendar.MINUTE));
	        xmlCalendar.setSecond(calandar.get(Calendar.SECOND));
	        xmlCalendar.setMillisecond(calandar.get(Calendar.MILLISECOND));
	        int offsetInMinutes = (calandar.get(Calendar.ZONE_OFFSET) + calandar.get(Calendar.DST_OFFSET)) / (60 * 1000);
	        xmlCalendar.setTimezone(offsetInMinutes);

	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	    return    xmlCalendar;
	}
}

