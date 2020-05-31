package com.example.demo.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PriceList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection
	@JoinTable(name="dates_price", joinColumns=@JoinColumn(name="Id"))
	@MapKeyColumn (name="dates_price_Id")
	@Column(name="value")
	private Map<Calendar, Double> datesPrice = new HashMap<Calendar, Double>();
	
	@ElementCollection
	@JoinTable(name="discount", joinColumns=@JoinColumn(name="Id"))
	@MapKeyColumn (name="discount_id")
	@Column(name="value")
	private Map<Calendar, Double> discount = new HashMap<Calendar, Double>();
	
	@Column(name="pricePerMile")
	private double pricePerMile;
	
	@Column(name="cdwPrice")
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
