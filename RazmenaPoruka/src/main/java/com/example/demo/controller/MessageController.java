package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MessageDTO;
import com.example.demo.model.Message;

@RestController
@RequestMapping("/message")
public class MessageController {

	@PostMapping(value = "/new")
	public ResponseEntity<String> sendMessage() {
		return new ResponseEntity<String>("Sent", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Message>> getAllMessage() {
		return new ResponseEntity<List<Message>>(new ArrayList<Message>(), HttpStatus.OK);
	}
	
	@PutMapping(value = "/edit")
	public ResponseEntity<MessageDTO> editMessage() {
		return new ResponseEntity<MessageDTO>(new MessageDTO(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteMessage() {
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
}
