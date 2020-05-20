package com.example.demo.dto;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.model.Ad;
import com.example.demo.model.Renter;
import com.example.demo.model.Vehicle;

public class AdDTO {

	private Renter renter;
	private Vehicle vehicle;
	private Calendar date;
	private Calendar validTru;
	private Calendar validFrom;
	private Map<Calendar, Boolean> free = new HashMap<Calendar, Boolean>();
	private int mileage;

	public AdDTO() {

	}

	public AdDTO(Renter renter, Vehicle vehicle, Calendar date, Calendar validTru, Calendar validFrom,
			HashMap<Calendar, Boolean> free, int mileage) {
		super();
		this.renter = renter;
		this.vehicle = vehicle;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.free = free;
		this.mileage = mileage;
	}

	public AdDTO(Ad a) {
		this(a.getUser(), a.getVehicle(), a.getDate(), a.getValidTru(), a.getValidFrom(), (HashMap<Calendar, Boolean>) a.getFree(), a. getMileage());
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
