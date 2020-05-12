package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Renter {

	private UserModel user;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private PriceList priceList;
	private List<Ad> ads = new ArrayList<Ad>();
	private List<Request> ordered = new ArrayList<Request>();
	private List<Review> reviews = new ArrayList<Review>();
	
	public Renter() {
		
	}

	public Renter(UserModel user, List<Vehicle> vehicles, PriceList priceList, List<Ad> ads, List<Request> ordered,
			List<Review> reviews) {
		super();
		this.user = user;
		this.vehicles = vehicles;
		this.priceList = priceList;
		this.ads = ads;
		this.ordered = ordered;
		this.reviews = reviews;
	}



	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public List<Request> getOrdered() {
		return ordered;
	}

	public void setOrdered(List<Request> ordered) {
		this.ordered = ordered;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
}
