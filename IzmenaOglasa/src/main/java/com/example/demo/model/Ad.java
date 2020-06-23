package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	private Renter renter;

	@OneToOne(fetch = FetchType.EAGER)
	private EndUser endUser;

	@OneToOne(fetch = FetchType.EAGER)
	private Vehicle vehicle;

	@Column(name="place")
	private String place;

	@Column(name="date", nullable = false)
	private Calendar date;

	@Column(name="validTru", nullable = false)
	private Calendar validTru;

	@Column(name="validFrom", nullable = false)
	private Calendar validFrom;

	@Column(name="dateFrom", nullable = false)
	private Calendar dateFrom;

	@Column(name="dateTo", nullable = false)
	private Calendar dateTo;

	@ElementCollection
	@JoinTable(name="free", joinColumns=@JoinColumn(name="Id"))
	@MapKeyColumn (name="free_Id")
	@Column(name="value")
	private Map<Calendar, Boolean> free = new HashMap<Calendar, Boolean>();

	@Column(name="mileage")
	private int mileage;

	public Ad() {

	}

	public Ad(Renter renter, Vehicle vehicle, Calendar date, Calendar validTru, Calendar validFrom,
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
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

	public void setFree(Map<Calendar, Boolean> free) {
		this.free = free;
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
