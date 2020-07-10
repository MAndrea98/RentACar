package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.demo.model.Ad;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.model.Request;
import com.example.demo.model.Vehicle;

public class AdDTO {

	private Long id;
	private Vehicle vehicle;
	private String place;
	private Calendar date;
	private Calendar validTru;
	private Calendar validFrom;
	private Calendar dateFrom;
	private Calendar dateTo;
	private List<EndUser> favoriteFor;
	private List<Request> requests = new ArrayList<Request>();
	private List<Cart> carts = new ArrayList<Cart>();

	public AdDTO() {

	}

	public AdDTO(Long id, Vehicle vehicle, String place, Calendar date, Calendar validTru, Calendar validFrom,
			Calendar dateFrom, Calendar dateTo, List<EndUser> favoriteFor, List<Request> requests, List<Cart> carts) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.place = place;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.favoriteFor = favoriteFor;
		this.requests = requests;
		this.carts = carts;
	}

	public AdDTO(Ad a) {
		this(a.getId(), a.getVehicle(), a.getPlace(), a.getDate(), a.getValidTru(), a.getValidFrom(), a.getDateFrom(),
				a.getDateTo(), a.getFavoriteFor(), a.getRequests(), a.getCarts());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getValidTru() {
		return validTru;
	}

	public void setValidTru(Calendar validTru) {
		this.validTru = validTru;
	}

	public Calendar getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Calendar validFrom) {
		this.validFrom = validFrom;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Calendar getDateTo() {
		return dateTo;
	}

	public void setDateTo(Calendar dateTo) {
		this.dateTo = dateTo;
	}

	public List<EndUser> getFavoriteFor() {
		return favoriteFor;
	}

	public void setFavoriteFor(List<EndUser> favoriteFor) {
		this.favoriteFor = favoriteFor;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	

}
