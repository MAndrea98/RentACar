package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Renter renter;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private EndUser endUser;

	@JsonIgnore
	@ManyToMany(mappedBy = "requests")
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Column(name="status")
	private String status;
	
	public Request() {
		
	}
	

	public Request(List<Vehicle> vehicles, String status, Renter renter) {
		super();
		this.vehicles = vehicles;
		this.status = status;
		this.renter = renter;
	}



	public List<Vehicle> getVehicle() {
		return vehicles;
	}

	public void setVehicle(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Renter getRenter() {
		return renter;
	}



	public void setRenter(Renter renter) {
		this.renter = renter;
	}
	
	
	
}
