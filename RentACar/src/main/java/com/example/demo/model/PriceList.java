package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;

public class PriceList {
	
	private HashMap<Calendar, Double> datesPrice = new HashMap<Calendar, Double>();
	private HashMap<Calendar, Double> discount = new HashMap<Calendar, Double>();
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

	public HashMap<Calendar, Double> getDatesPrice() {
		return datesPrice;
	}

	public void setDatesPrice(HashMap<Calendar, Double> datesPrice) {
		this.datesPrice = datesPrice;
	}

	public HashMap<Calendar, Double> getDiscount() {
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
