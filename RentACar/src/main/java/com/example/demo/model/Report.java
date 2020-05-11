package com.example.demo.model;

public class Report {

	private Request request;
	private Review review;
	
	public Report() {
		
	}

	public Report(Request request, Review review) {
		super();
		this.request = request;
		this.review = review;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	
}
