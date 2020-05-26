package com.example.demo.model;

public class Request {

	private Long id;

	private Renter renter;

	private EndUser endUser;

	private String status;

	public Request() {

	}


	public Request(String status, Renter renter) {
		super();
		this.status = status;
		this.renter = renter;
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



}
