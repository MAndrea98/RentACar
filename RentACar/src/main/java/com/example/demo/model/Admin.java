package com.example.demo.model;

public class Admin {

	private User user;
	
	public Admin() {
		
	}

	public Admin(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
