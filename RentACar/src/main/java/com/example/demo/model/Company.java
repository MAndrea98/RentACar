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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade=CascadeType.ALL)
	private Renter renter;
	
	@Column(name="name",nullable=false)
	private String name;

	@Column(name="address",nullable=false)
	private String address;
	
	@Column(name="poslovniMaticniBroj",nullable=false)
	private String poslovniMaticniBroj;
	
	@JsonIgnore
	@OneToMany(mappedBy="company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Agent> agents = new ArrayList<Agent>();

	public Company() {
		
	}

	public Company(Renter renter, String name, String address, List<Agent> agents, String poslovniMaticniBroj) {
		super();
		this.renter = renter;
		this.name = name;
		this.address = address;
		this.agents = agents;
		this.poslovniMaticniBroj = poslovniMaticniBroj;
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
	
	public void setPoslovniMaticniBroj(String poslovniMaticniBroj) {
		this.poslovniMaticniBroj = poslovniMaticniBroj;
	}

	public String getPoslovniMaticniBroj() {
		return poslovniMaticniBroj;
	}
	
	
}
