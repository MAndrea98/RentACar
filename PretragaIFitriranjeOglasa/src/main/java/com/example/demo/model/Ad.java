package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Ad {


	private Long id;

	private Renter renter;

	private EndUser endUser;

	private Vehicle vehicle;

	private String place;

	private Calendar date;

	private Calendar validTru;

	private Calendar validFrom;

	private Calendar dateFrom;

	private Calendar dateTo;

	private Map<Calendar, Boolean> free = new HashMap<Calendar, Boolean>();

	private int mileage;

	public Ad() {

	}

	public Ad(Renter renter, Vehicle vehicle, String place, Calendar date, Calendar validTru, Calendar validFrom,
			Calendar dateFrom, Calendar dateTo, HashMap<Calendar, Boolean> free, int mileage) {
		super();
		this.renter = renter;
		this.vehicle = vehicle;
		this.place = place;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.free = free;
		this.mileage = mileage;
	}
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public Renter getUser() {
		return renter;
	}
	public void setUser(Renter renter) {
		this.renter = renter;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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
	public Map<Calendar, Boolean> getFree() {
		return free;
	}
	public void setFree(HashMap<Calendar, Boolean> free) {
		this.free = free;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


}
