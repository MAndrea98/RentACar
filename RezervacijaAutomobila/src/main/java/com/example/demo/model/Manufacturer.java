package com.example.demo.model;


public class Manufacturer {
	
	private Long id;

	private String name;
	
	public Manufacturer() {
		
	}

	public Manufacturer(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
