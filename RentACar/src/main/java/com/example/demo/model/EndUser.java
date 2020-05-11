package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class EndUser {
	
	private User user;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private List<Review> reviews = new ArrayList<Review>();
	private List<Ad> favorites = new ArrayList<Ad>();
	private List<Request> requsets = new ArrayList<Request>();
	
	public EndUser() {
		
	}

	public EndUser(User user, String name, String surname, String address, String phone, List<Review> reviews,
			List<Ad> favorites, List<Request> requsets) {
		super();
		this.user = user;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.reviews = reviews;
		this.favorites = favorites;
		this.requsets = requsets;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Ad> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Ad> favorites) {
		this.favorites = favorites;
	}

	public List<Request> getRequsets() {
		return requsets;
	}

	public void setRequsets(List<Request> requsets) {
		this.requsets = requsets;
	}
	
	

}
