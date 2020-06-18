package com.example.demo.dto;

import java.util.Calendar;

import com.example.demo.model.Message;

public class MessageDTO {

	private Long id;
	private String senderUsername;
	private String receiverUsername;
	private String subject;
	private String content;
	private Calendar date;
	
	public MessageDTO() {
		
	}

	public MessageDTO(Long id, String senderUsername, String receiverUsername, String subject, String content, Calendar date) {
		super();
		this.id = id;
		this.senderUsername = senderUsername;
		this.receiverUsername = receiverUsername;
		this.subject = subject;
		this.content = content;
		this.date = date;
	}

	public MessageDTO(Message m) {
		this(m.getId(), 
			m.getSender().getUsername(), 
			m.getReciever().getUsername(), 
			m.getSubject(), 
			m.getContent(), 
			m.getDate());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getReceiverUsername() {
		return receiverUsername;
	}

	public void setReceiverUsername(String receiverUsername) {
		this.receiverUsername = receiverUsername;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
}
