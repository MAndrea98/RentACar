package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;


public class Request {
	
	private Long id;
	
	private Renter renter;
	
	private EndUser endUser;

	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
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
