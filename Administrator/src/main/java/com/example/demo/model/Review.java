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

	@ManyToOne(fetch = FetchType.LAZY)
	private EndUser endUser;

	@ManyToOne(fetch = FetchType.LAZY)
	private Renter renter;
	
	@Column(name="stars")
	private int stars;
	
	@Column(name="content")
	private String content;
	
	@Column(name="accepted")
	private Boolean accepted;
	
	@Column(name = "deleted")
	private Boolean deleted;
	
	public Review(){
		this.accepted = false;
		this.deleted = false;
	}
	
	public Review(EndUser endUser, int stars, String content) {
		super();
		this.endUser = endUser;
		this.stars = stars;
		this.content = content;
		this.accepted = false;
		this.deleted = false;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
}
