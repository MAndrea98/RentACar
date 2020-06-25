package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VehicleFree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Vehicle vehicle;
	
	@Column(name="dateFrom", nullable = false)
	private Calendar dateFrom;

	@Column(name="dateTo", nullable = false)
	private Calendar dateTo;

	public VehicleFree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleFree(Long id, Vehicle vehicle, Calendar dateFrom, Calendar dateTo) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
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
	
	
}
