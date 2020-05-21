package com.example.demo.model;


public class GasType {
	
	private Long id;

	private String name;
	
	public GasType() {
		
	}

	
	public GasType(String name) {
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
