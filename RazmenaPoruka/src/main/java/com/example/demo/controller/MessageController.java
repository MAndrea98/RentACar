package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageDTO;
import com.example.demo.model.EndUser;
import com.example.demo.model.Message;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.UserModel;
import com.example.demo.service.AdService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.MessageService;
import com.example.demo.service.RenterService;
import com.example.demo.service.RequestService;
import com.example.demo.service.UserModelService;

@RefreshScope
@RestController
@RequestMapping("/message")
@CrossOrigin
public class MessageController {
	
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
	
	@Autowired
	AdService adService;

	@PostMapping(value = "/{id}")
	public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDTO,
												  @PathVariable("id") Long id) {
		//UserModel sender = userModelService.findById(LogedUser.getInstance().getUserId());
		System.out.println(messageDTO);
		UserModel sender = userModelService.findById(1L);
		UserModel reciever = userModelService.findByUsername(messageDTO.getReceiver().getUsername());
		Renter renter = renterService.findByIdUser(sender.getId());
		EndUser endUser = endUserService.findByIdUser(reciever.getId());
		if (renter == null && endUser == null) {
			renter = renterService.findByIdUser(reciever.getId());
			endUser = endUserService.findByIdUser(sender.getId());
			if (renter == null && endUser == null) {
				System.out.println("####1");
				return new ResponseEntity<MessageDTO>(HttpStatus.BAD_REQUEST);
			}
		}
		
		Request request = requestService.findById(id);
		System.out.println("####" + request.getStatus());
		if (!request.getStatus().equals(RequestStatus.RESERVED)) {
			System.out.println("####2");
			return new ResponseEntity<MessageDTO>(HttpStatus.BAD_REQUEST); 
		}
		
		Message message = new Message(sender, reciever, messageDTO.getSubject(), messageDTO.getContent(), Calendar.getInstance(), request);
		Message m = messageService.save(message);
		return new ResponseEntity<MessageDTO>(new MessageDTO(m), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Message>> getAllMessage() {
		//UserModel user = userModelService.findById(LogedUser.getInstance().getUserId());
		UserModel user = userModelService.findById(1L);
		List<Message> allNotDeletedMessages = new ArrayList<Message>();
		for (Message m : user.getInbox())
			if (!m.isDeleted())
				allNotDeletedMessages.add(m);
		
		for (Message m : user.getOutbox())
			if (!m.isDeleted())
				allNotDeletedMessages.add(m);
		
		return new ResponseEntity<List<Message>>(allNotDeletedMessages, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<MessageDTO> editMessage(@RequestBody MessageDTO messageDTO) {
		Message message = messageService.findById(messageDTO.getId());
		message.setSubject(messageDTO.getSubject());
		message.setContent(messageDTO.getContent());
		Message m = messageService.save(message);
		return new ResponseEntity<MessageDTO>(new MessageDTO(m), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MessageDTO> deleteMessage(@PathVariable("id") Long id) {
		Message message = messageService.findById(id);
		message.setDeleted(true);
		Message m = messageService.save(message);
		return new ResponseEntity<MessageDTO>(new MessageDTO(m), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{requestID}")
	public ResponseEntity<List<MessageDTO>> getMessagesOfRequest(@PathVariable("requestID") Long requestID) {
		Request request = requestService.findById(requestID);
		List<Message> messages = messageService.findByRequest(request);
		List<MessageDTO> messageDTOs = new ArrayList<MessageDTO>();
		for (Message m : messages) {
			messageDTOs.add(new MessageDTO(m));
		}
		return new ResponseEntity<List<MessageDTO>>(messageDTOs, HttpStatus.OK);
	}
}
