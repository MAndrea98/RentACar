package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VehicleImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Vehicle vehicle;
	
	@Column(name="image")
	private String image;

	public VehicleImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getVehicleID() {
		return vehicle;
	}

	public void vehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	} 
	
	
}
