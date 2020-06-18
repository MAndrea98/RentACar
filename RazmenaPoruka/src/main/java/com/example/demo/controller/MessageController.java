package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageDTO;
import com.example.demo.model.Message;
import com.example.demo.model.UserModel;
import com.example.demo.service.MessageService;
import com.example.demo.service.UserModelService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	UserModelService userModelService;
	
	@Autowired
	MessageService messageService;

	@PostMapping
	public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDTO) {
		//UserModel sender = userModelService.findById(LogedUser.getInstance().getUserId());
		UserModel sender = userModelService.findById(1L);
		UserModel reciever = userModelService.findByUsername(messageDTO.getReceiverUsername());
		// TODO prosiriti jos da li sme da se salje 
		
		Message message = new Message(sender, reciever, messageDTO.getSubject(), messageDTO.getContent(), Calendar.getInstance());
		Message m = messageService.save(message);
		return new ResponseEntity<MessageDTO>(new MessageDTO(m), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Message>> getAllMessage() {
		//UserModel user = userModelService.findById(LogedUser.getInstance().getUserId());
		UserModel user = userModelService.findById(2L);
		List<Message> allNotDeletedMessages = new ArrayList<Message>();
		for (Message m : user.getInbox())
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
}
