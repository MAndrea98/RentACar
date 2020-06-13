package com.example.demo.model;

public class LogedUser {

	private static LogedUser instance = new LogedUser();
	private Long userId;
	
	public LogedUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static LogedUser getInstance() {
		if (instance == null)
			instance = new LogedUser();
		
		return instance;
	}

	public static void setInstance(LogedUser instance) {
		LogedUser.instance = instance;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
