package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;



public class Renter {


	private Long id;

	private Long idUser;

	private PriceList priceList;

	private List<Ad> ads = new ArrayList<Ad>();

	private List<Review> reviews = new ArrayList<Review>();

	public Renter() {

	}

	public Renter(UserModel user, PriceList priceList, List<Ad> ads,
			List<Review> reviews) {
		super();
		this.priceList = priceList;
		this.ads = ads;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


}
