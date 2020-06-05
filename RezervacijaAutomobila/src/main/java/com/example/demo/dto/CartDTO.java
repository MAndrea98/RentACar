package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cart;
import com.example.demo.model.Vehicle;

public class CartDTO {

	private Long id;
	private Long endUserID;
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Long id, Long endUserID, List<Vehicle> vehicles) {
		super();
		this.id = id;
		this.endUserID = endUserID;
		this.vehicles = vehicles;
	}
	
	public CartDTO(Cart c) {
		this(c.getId(), c.getEndUserID(), c.getVehicles());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEndUserID() {
		return endUserID;
	}

	public void setEndUserID(Long endUserID) {
		this.endUserID = endUserID;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	

}
