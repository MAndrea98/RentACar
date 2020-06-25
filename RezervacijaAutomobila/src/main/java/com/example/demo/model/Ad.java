package com.example.demo.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	@ManyToMany
	private List<EndUser> favoriteFor;

	public Ad() {

	}

	public Ad(Long id, Vehicle vehicle, String place, Calendar date, Calendar validTru, Calendar validFrom,
			Calendar dateFrom, Calendar dateTo,
			List<EndUser> favoriteFor) {
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

	
}
