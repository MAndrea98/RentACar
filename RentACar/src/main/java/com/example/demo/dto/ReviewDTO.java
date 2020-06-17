package com.example.demo.dto;

import com.example.demo.model.Request;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;

public class ReviewDTO {

	private Long id;
	private String endUserUsername;
	private String renterUsername;
	private int stars;
	private String content;
	private Long requestID;
	private boolean accepted;
	private boolean deleted;
	
	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewDTO(Long id, String endUserUsername, String renterUsername, int stars, String content, Long requestID, boolean accepted, boolean deleted) {
		super();
		this.id = id;
		this.endUserUsername = endUserUsername;
		this.renterUsername = renterUsername;
		this.stars = stars;
		this.content = content;
		this.requestID = requestID;
		this.accepted = accepted;
		this.deleted = deleted;
	}
	
	public ReviewDTO(Review rev, Request req, UserModel endUser, UserModel renterUser) {
		this(rev.getId(), endUser.getUsername(), renterUser.getUsername(), rev.getStars(), rev.getContent(), req.getId(), rev.isAccepted(), rev.isDeleted());
	}

	public ReviewDTO(Review r) {
		this.id = r.getId();
		this.stars = r.getStars();
		this.content = r.getContent();
		
	}
	
	public ReviewDTO(Review r, String renter, String endUser) {
		this.id = r.getId();
		this.stars = r.getStars();
		this.content = r.getContent();
		this.renterUsername = renter;
		this.endUserUsername = endUser;
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

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
