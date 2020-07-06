package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Ad;
import com.example.demo.model.Cart;

public class CartDTO {

	private Long id;
	private Long endUserID;
	private List<Ad> ads = new ArrayList<Ad>();
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Long id, Long endUserID, List<Ad> ads) {
		super();
		this.id = id;
		this.endUserID = endUserID;
		this.ads = ads;
	}
	
	public CartDTO(Cart c) {
		this(c.getId(), c.getEndUserID(), c.getAds());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEndUserID() {
		return endUserID;
	}

	public void setEndUserID(Long endUserID) {
		this.endUserID = endUserID;
	}

	public List<Ad> getVehicles() {
		return ads;
	}

	public void setVehicles(List<Ad> ads) {
		this.ads = ads;
	}
	
	

}
