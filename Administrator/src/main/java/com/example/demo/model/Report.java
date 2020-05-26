package com.example.demo.model;



public class Report {

	private Long id;

	private Review review;

	public Report() {

	}

	public Report(Review review) {
		super();
		this.review = review;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}


}
