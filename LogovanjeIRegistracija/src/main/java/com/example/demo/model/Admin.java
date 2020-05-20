package com.example.demo.model;


public class Admin {

	private Long id;

	private UserModel user;
	
	public Admin() {
		
	}

	public Admin(UserModel user) {
		super();
		this.user = user;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
	
}
