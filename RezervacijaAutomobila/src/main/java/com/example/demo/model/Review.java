package com.example.demo.model;


public class Review {
	
	private Long id;

	private EndUser endUser;
	
	private Renter renter;
	
	private int stars;
	
	private String content;
	
	public Review(){
	
	}
	
	public Review(EndUser endUser, int stars, String content) {
		super();
		this.endUser = endUser;
		this.stars = stars;
		this.content = content;
	}



	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
