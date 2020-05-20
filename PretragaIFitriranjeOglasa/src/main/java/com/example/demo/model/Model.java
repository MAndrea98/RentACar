package com.example.demo.model;

public class Model {
	

	private Long id;

	private String name;
	
	private Manufacturer manufacturer;
	
	public Model() {
		
	}

	public Model(String name, Manufacturer manufacturer) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
