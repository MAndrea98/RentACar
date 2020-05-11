package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Request {

	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	private String status;
	
	public Request() {
		
	}
	
	

	public Request(List<Vehicle> vehicle, String status) {
		super();
		this.vehicle = vehicle;
		this.status = status;
	}



	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
