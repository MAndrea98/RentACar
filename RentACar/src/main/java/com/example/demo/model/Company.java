package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

	private Renter renter;
	private String name;
	private String address;
	private List<Agent> agents = new ArrayList<Agent>();

	public Company() {
		
	}

	public Company(Renter renter, String name, String address, List<Agent> agents) {
		super();
		this.renter = renter;
		this.name = name;
		this.address = address;
		this.agents = agents;
	}

	public Renter getRenter() {
		return renter;
	}

	public void setRenter(Renter renter) {
		this.renter = renter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	
}
