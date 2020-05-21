package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class UserModel {
	
	private Long id;

	private String username;
	
	private String password;
	
	private UserType uloga;
	
	private List<Message> inbox = new ArrayList<Message>();
	
	private List<Message> outbox = new ArrayList<Message>();
	

	private Set<Permissions> permissions = new HashSet<Permissions>();
	
	public UserModel() {
		
	}

	public UserModel(String username, String password, UserType uloga, List<Message> inbox, List<Message> outbox,
			Set<Permissions> permissions) {
		super();
		this.username = username;
		this.password = password;
		this.uloga = uloga;
		this.inbox = inbox;
		this.outbox = outbox;
		this.permissions = permissions;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUloga() {
		return uloga;
	}

	public void setUloga(UserType uloga) {
		this.uloga = uloga;
	}

	public List<Message> getInbox() {
		return inbox;
	}

	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}

	public List<Message> getOutbox() {
		return outbox;
	}

	public void setOutbox(List<Message> outbox) {
		this.outbox = outbox;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permissions> permissions) {
		this.permissions = permissions;
	}
	
	
}
