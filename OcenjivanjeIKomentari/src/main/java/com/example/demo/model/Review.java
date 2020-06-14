package com.example.demo.model;


public class Review {
	
	private Long id;

	private EndUser endUser;
	
	private Renter renter;
	
	private int stars;
	
	private String content;
	
	private boolean accepted;
	
	public Review(){
		this.accepted = false;
	}
	
	public Review(EndUser endUser, int stars, String content) {
		super();
		this.endUser = endUser;
		this.stars = stars;
		this.content = content;
		this.accepted = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
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
