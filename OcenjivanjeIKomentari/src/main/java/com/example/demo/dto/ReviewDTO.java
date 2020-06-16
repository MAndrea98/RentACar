package com.example.demo.dto;

import com.example.demo.model.Request;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;

public class ReviewDTO {

	private String endUserUsername;
	private String renterUsername;
	private int stars;
	private String content;
	private Long requestID;
	
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(String endUserUsername, String renterUsername, int stars, String content, Long requestID) {
		super();
		this.endUserUsername = endUserUsername;
		this.renterUsername = renterUsername;
		this.stars = stars;
		this.content = content;
		this.requestID = requestID;
	}
	
	public ReviewDTO(Review rev, Request req, UserModel endUser, UserModel renterUser) {
		this(endUser.getUsername(), renterUser.getUsername(), rev.getStars(), rev.getContent(), req.getId());
	}

	public String getEndUserUsername() {
		return endUserUsername;
	}

	public void setEndUserUsername(String endUserUsername) {
		this.endUserUsername = endUserUsername;
	}

	public String getRenterUsername() {
		return renterUsername;
	}

	public void setRenterUsername(String renterUsername) {
		this.renterUsername = renterUsername;
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

	public Long getRequestID() {
		return requestID;
	}

	public void setRequestID(Long requestID) {
		this.requestID = requestID;
	}
	
}
