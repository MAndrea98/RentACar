package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.Vehicle;

public class RequestDTO {
	
	private Long id;
	private Renter renter;
	private EndUser endUser;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private String status;
	
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDTO(Long id, Renter renter, EndUser endUser, List<Vehicle> vehicles, String status) {
		super();
		this.id = id;
		this.renter = renter;
		this.endUser = endUser;
		this.vehicles = vehicles;
		this.status = status;
	}
	
	public RequestDTO(Request r) {
		this(r.getId(), r.getRenter(), r.getEndUser(), r.getVehicles(), r.getStatus());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
