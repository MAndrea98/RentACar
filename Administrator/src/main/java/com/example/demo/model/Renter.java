package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;




public class Renter {

	private Long id;

	private Long idUser;

	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	private PriceList priceList;

	private List<Review> reviews = new ArrayList<Review>();

	public Renter() {

	}

	public Renter(UserModel user, List<Vehicle> vehicles, PriceList priceList,
			List<Review> reviews) {
		super();
		this.vehicles = vehicles;
		this.priceList = priceList;
		this.reviews = reviews;
	}



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


}
