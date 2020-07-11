package com.example.demo.model;

public class LoggedUser {

	private static LoggedUser instance = new LoggedUser();
	private Long id;
	
	public LoggedUser() {
		
	}

	public static LoggedUser getInstance() {
		if(instance == null)
			instance = new LoggedUser();
		return instance;
	}

	public static void setInstance(LoggedUser instance) {
		LoggedUser.instance = instance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
