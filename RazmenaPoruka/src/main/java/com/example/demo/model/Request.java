package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Renter renter;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private EndUser endUser;

	@Column(name="status")
	private String status;

	public Request() {

	}

	public Request(Long id, Renter renter, EndUser endUser, String status) {
		super();
		this.id = id;
		this.renter = renter;
		this.endUser = endUser;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Renter getRenter() {
		return renter;
	}



	public void setRenter(Renter renter) {
		this.renter = renter;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public EndUser getEndUser() {
		return endUser;
	}


	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}


}
