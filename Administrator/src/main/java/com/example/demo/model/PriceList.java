package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class PriceList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToMany
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	@Column(name="dateFrom", nullable = false)
	private Calendar dateFrom;

	@Column(name="dateTo", nullable = false)
	private Calendar dateTo;
	
	@Column(name="pricePerMile")
	private double pricePerMile;
	
	@Column(name="cdwPrice")
	private double cdwPrice;
	
	
	public PriceList() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getPricePerMile() {
		return pricePerMile;
	}

	public void setPricePerMile(double pricePerMile) {
		this.pricePerMile = pricePerMile;
	}

	public double getCdwPrice() {
		return cdwPrice;
	}

	public void setCdwPrice(double cdwPrice) {
		this.cdwPrice = cdwPrice;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
