package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private double value;
	
	@Column(name="validTru", nullable = false)
	private Calendar validTru;

	@Column(name="validFrom", nullable = false)
	private Calendar validFrom;
	
	@OneToOne(fetch = FetchType.EAGER)
	private PriceList priceList;

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discount(Long id, double value, Calendar validTru, Calendar validFrom, PriceList priceList) {
		super();
		this.id = id;
		this.value = value;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.priceList = priceList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}
	
	
	
}
