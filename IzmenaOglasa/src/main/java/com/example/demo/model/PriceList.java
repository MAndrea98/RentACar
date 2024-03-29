package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;

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
	
	@ElementCollection
	@JoinTable(name="prices_values", joinColumns = @JoinColumn(name="price_list_id"))
	@MapKeyColumn (name="name")
	@Column(name="price")
	private Map<String, Double> prices = new HashMap<String, Double>();

	public PriceList() {
		dateFrom = Calendar.getInstance();
		dateTo = Calendar.getInstance();
	}

	public PriceList(Long id, List<Vehicle> vehicle, Calendar dateFrom, Calendar dateTo, double pricePerMile,
			double cdwPrice) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.pricePerMile = pricePerMile;
		this.cdwPrice = cdwPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
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

	public Map<String, Double> getPrices() {
		return prices;
	}

	public void setPrices(Map<String, Double> prices) {
		this.prices = prices;
	}

	

	


}
