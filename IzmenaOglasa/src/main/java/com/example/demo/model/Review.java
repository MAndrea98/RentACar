package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private EndUser endUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Renter renter;
	
	@Column(name="stars")
	private int stars;
	
	@Column(name="content")
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
