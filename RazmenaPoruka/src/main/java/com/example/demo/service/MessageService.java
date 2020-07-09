package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.model.Request;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	public Message save(Message message) {
		return messageRepository.save(message);
	}

	public Message findById(Long id) {
		return messageRepository.findById(id).orElse(null);
	}

	public void delete(Message message) {
		messageRepository.delete(message);
	}
	
	public List<Message> findByRequest(Request request) {
		return messageRepository.findByRequest(request);
	}
	
}
