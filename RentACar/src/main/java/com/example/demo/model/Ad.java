package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;

public class Ad {

	private UserModel user;
	private Vehicle vehicle;
	private Calendar date;
	private Calendar validTru;
	private Calendar validFrom;
	private HashMap<Calendar, Boolean> free = new HashMap<Calendar, Boolean>();
	private int mileage;
	
	public Ad() {
		
	}
	
	public Ad(UserModel user, Vehicle vehicle, Calendar date, Calendar validTru, Calendar validFrom,
			HashMap<Calendar, Boolean> free, int mileage) {
		super();
		this.user = user;
		this.vehicle = vehicle;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.free = free;
		this.mileage = mileage;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
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
	public HashMap<Calendar, Boolean> getFree() {
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
