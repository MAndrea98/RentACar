package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Renter {

	private Long id;

	private Long idUser;

	private PriceList priceList;

	private List<Ad> ads = new ArrayList<Ad>();

	private List<Request> ordered = new ArrayList<Request>();

	public Renter() {

	}

	public Renter(UserModel user, PriceList priceList, List<Ad> ads, List<Request> ordered) {
		super();
		this.priceList = priceList;
		this.ads = ads;
		this.ordered = ordered;
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

	public List<Request> getOrdered() {
		return ordered;
	}

	public void setOrdered(List<Request> ordered) {
		this.ordered = ordered;
	}

}
