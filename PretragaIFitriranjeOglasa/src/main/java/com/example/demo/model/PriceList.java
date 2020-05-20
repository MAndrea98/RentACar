package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class PriceList {
	

	private Long id;
	
	private Map<Calendar, Double> datesPrice = new HashMap<Calendar, Double>();
	
	private Map<Calendar, Double> discount = new HashMap<Calendar, Double>();

	private double pricePerMile;
	
	private double cdwPrice;
	
	public PriceList() {
		
	}

	public PriceList(HashMap<Calendar, Double> datesPrice, HashMap<Calendar, Double> discount, double pricePerMile,
			double cdwPrice) {
		super();
		this.datesPrice = datesPrice;
		this.discount = discount;
		this.pricePerMile = pricePerMile;
		this.cdwPrice = cdwPrice;
	}

	public Map<Calendar, Double> getDatesPrice() {
		return datesPrice;
	}

	public void setDatesPrice(HashMap<Calendar, Double> datesPrice) {
		this.datesPrice = datesPrice;
	}

	public Map<Calendar, Double> getDiscount() {
		return discount;
	}

	public void setDiscount(HashMap<Calendar, Double> discount) {
		this.discount = discount;
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
	
	
}
