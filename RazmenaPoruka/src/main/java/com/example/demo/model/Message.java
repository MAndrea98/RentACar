package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	private UserModel sender;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	private UserModel reciever;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="content")
	private String content;
	
	@Column(name="date", nullable = false)
	private Calendar date;
	
	@Column(name="deleted", nullable = false)
	private boolean deleted;
	
	@OneToOne
	private Request request;
	
	public Message() {
		this.deleted = false;
	}

	public Message(UserModel sender, UserModel reciever, String subject, String content, Calendar date, Request request) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.subject = subject;
		this.content = content;
		this.date = date;
		this.deleted = false;
		this.request = request;
	}
	
	public Message(UserModel sender, UserModel reciever, String subject, String content, Calendar date) {
		super();
		this.sender = sender;
		this.reciever = reciever;
		this.subject = subject;
		this.content = content;
		this.date = date;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", reciever=" + reciever + ", subject=" + subject
				+ ", content=" + content + ", date=" + date + ", deleted=" + deleted + ", request=" + request + "]";
	}
	
	
	
	
}
