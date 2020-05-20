package com.example.demo.model;

import java.util.Calendar;


public class Message {
	
	
	private Long id;

	private UserModel sender;

	private UserModel reciever;

	private String subject;
	
	private String content;

	private Calendar date;
	
	public Message() {
		
	}

	public Message(UserModel sender, UserModel reciever, String subject, String content, Calendar date) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.subject = subject;
		this.content = content;
		this.date = date;
	}

	public UserModel getSender() {
		return sender;
	}

	public void setSender(UserModel sender) {
		this.sender = sender;
	}

	public UserModel getReciever() {
		return reciever;
	}

	public void setReciever(UserModel reciever) {
		this.reciever = reciever;
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
