package com.example.demo.dto;

import java.util.Calendar;

import com.example.demo.model.Message;
import com.example.demo.model.UserModel;

public class MessageDTO {

	private Long id;
	private UserModel sender;
	private UserModel receiver;
	private String subject;
	private String content;
	private Calendar date;
	
	public MessageDTO() {
		
	}

	public MessageDTO(Long id, UserModel sender, UserModel receiver, String subject, String content, Calendar date) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
		this.date = date;
	}

	public MessageDTO(Message m) {
		this(m.getId(), 
			m.getSender(), 
			m.getReciever(), 
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

	public UserModel getSender() {
		return sender;
	}

	public void setSender(UserModel sender) {
		this.sender = sender;
	}

	public UserModel getReceiver() {
		return receiver;
	}

	public void setReceiver(UserModel receiver) {
		this.receiver = receiver;
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

	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", subject=" + subject
				+ ", content=" + content + ", date=" + date + "]";
	}
	
	
	
}
