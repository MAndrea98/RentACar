package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;




public class Ad {


	private Long id;

	private Renter renter;

	private EndUser endUser;

	private Calendar date;

	private Calendar validTru;

	private Calendar validFrom;

	private Map<Calendar, Boolean> free = new HashMap<Calendar, Boolean>();

	private int mileage;

	public Ad() {

	}

	public Ad(Renter renter, Calendar date, Calendar validTru, Calendar validFrom,
			HashMap<Calendar, Boolean> free, int mileage) {
		super();
		this.renter = renter;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.free = free;
		this.mileage = mileage;
	}
	public Renter getUser() {
		return renter;
	}
	public void setUser(Renter renter) {
		this.renter = renter;
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
