package com.example.demo.endpoint;

import java.util.Calendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.model.EndUser;
import com.example.demo.model.Message;
import com.example.demo.model.Renter;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.service.EndUserService;
import com.example.demo.service.MessageService;
import com.example.demo.service.RenterService;
import com.example.demo.service.RequestService;
import com.example.demo.service.UserModelService;

import localhost._8089.api.razmenaporuka.DeleteMessageRequest;
import localhost._8089.api.razmenaporuka.DeleteMessageResponse;
import localhost._8089.api.razmenaporuka.EditMessageRequest;
import localhost._8089.api.razmenaporuka.EditMessageResponse;
import localhost._8089.api.razmenaporuka.GetAllMessageResponse;
import localhost._8089.api.razmenaporuka.MessageRP;
import localhost._8089.api.razmenaporuka.SendMessageRequest;
import localhost._8089.api.razmenaporuka.SendMessageResponse;
import localhost._8089.api.razmenaporuka.UserModelRP;
import localhost._8089.api.razmenaporuka.UserTypeRP;

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

	// kreira poruku, sacuva je u bazi i vrati na agentsku poruku da je uspelo
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "sendMessageRequest")
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
		
		// TODO ispraviti gresku null vrednosti
		//Uvek je vracao null pa sam za sada zakomentarisao
		/*
		 * Request request = requestService.findByParameters(renter, endUser,
		 * "RESERVED"); if (request == null) { System.out.println("####2");
		 * response.setResponse("BAD REQUEST"); return response; }
		 */
		try {
			Message message = new Message(sender, reciever, messageDTO.getMessage().getSubject(),
					messageDTO.getMessage().getContent(), Calendar.getInstance());
			messageService.save(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("ZAVRSIO");
		response.setResponse("MESSAGE SENT");
		
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMessageRequest")
	@ResponsePayload
	public GetAllMessageResponse getAllMessages() {
		UserModel user = userModelService.findById(1L);
		GetAllMessageResponse response = new GetAllMessageResponse();
		for (Message m : user.getInbox())
			if (!m.isDeleted()) {
				MessageRP msg = new MessageRP();
				UserModelRP receiver = new UserModelRP();
				UserModelRP sender = new UserModelRP();

				receiver.setPassword(user.getPassword());
				receiver.setUsername(user.getUsername());
				receiver.setUloga(toUserTypeXML(user.getUloga()));

				sender.setPassword(user.getPassword());
				sender.setUsername(user.getUsername());
				sender.setUloga(toUserTypeXML(user.getUloga()));

				msg.setContent(m.getContent());
				msg.setDate(toXMLCalendar(m.getDate()));
				msg.setReciever(receiver);
				msg.setSender(sender);
				msg.setSubject(m.getSubject());

				response.getMessages().add(msg);
			}
		System.out.println("ZAVRSIO");

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "editMessageRequest")
	@ResponsePayload
	public EditMessageResponse editMessage(@RequestPayload EditMessageRequest messageDTO) {
		
		System.out.println(messageDTO.getMessage().getId());
	  
	    Message message = messageService.findById(messageDTO.getMessage().getId());
	    message.setSubject(messageDTO.getMessage().getSubject());
	    message.setContent(messageDTO.getMessage().getContent());
	    messageService.save(message);
	  
	    EditMessageResponse response = new EditMessageResponse();
	    response.setResponse("EDIT SUCCESSFUL");
	    return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteMessageRequest")
	@ResponsePayload
	public DeleteMessageResponse deleteMessage(@RequestPayload DeleteMessageRequest request) {
		System.err.println(request.getMessageId());
		DeleteMessageResponse response = new DeleteMessageResponse();
		Message message = messageService.findById(request.getMessageId());
		if(message.isDeleted()) {
			response.setResponse("MESSAGE ALREADY DELETED");
			return response;
		}
		message.setDeleted(true);
		messageService.save(message);
		
		
		response.setResponse("DELETE SUCCESSFUL");
		return response;		
	}
	 

	public static XMLGregorianCalendar toXMLCalendar(Calendar calandar) {
		XMLGregorianCalendar xmlCalendar = null;
		try {
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			xmlCalendar = dtf.newXMLGregorianCalendar();
			xmlCalendar.setYear(calandar.get(Calendar.YEAR));
			xmlCalendar.setDay(calandar.get(Calendar.DAY_OF_MONTH));
			xmlCalendar.setMonth(calandar.get(Calendar.MONTH) + 1);
			xmlCalendar.setHour(calandar.get(Calendar.HOUR_OF_DAY));
			xmlCalendar.setMinute(calandar.get(Calendar.MINUTE));
			xmlCalendar.setSecond(calandar.get(Calendar.SECOND));
			xmlCalendar.setMillisecond(calandar.get(Calendar.MILLISECOND));
			int offsetInMinutes = (calandar.get(Calendar.ZONE_OFFSET) + calandar.get(Calendar.DST_OFFSET))
					/ (60 * 1000);
			xmlCalendar.setTimezone(offsetInMinutes);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlCalendar;
	}

	public static UserTypeRP toUserTypeXML(UserType uloga) {
		UserTypeRP ulogaXML;

		if (uloga == UserType.ADMIN) {
			ulogaXML = UserTypeRP.ADMIN;
		} else if (uloga == UserType.END_USER) {
			ulogaXML = UserTypeRP.ENDUSER;
		} else if (uloga == UserType.RENTER) {
			ulogaXML = UserTypeRP.RENTER;
		} else {
			ulogaXML = UserTypeRP.ENDUSER;
		}

		return ulogaXML;
	}
}
