package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.PriceList;
import com.example.demo.model.Vehicle;

public class PriceListDTO {

	private Long id;
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	private Date dateFrom;
	private Date dateTo;
	private double pricePerMile;
	private double cdwPrice;
	private Map<String, Double> prices = new HashMap<String, Double>();
	
	public PriceListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PriceListDTO(Long id, List<Vehicle> vehicle, Date dateFrom, Date dateTo, double pricePerMile,
			double cdwPrice, Map<String, Double> prices) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.pricePerMile = pricePerMile;
		this.cdwPrice = cdwPrice;
		this.prices = prices;
	}
	
	public PriceListDTO(PriceList p) {
		this(p.getId(), p.getVehicle(), p.getDateFrom().getTime(), p.getDateTo().getTime(), p.getPricePerMile(), p.getCdwPrice(), p.getPrices());
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

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
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
