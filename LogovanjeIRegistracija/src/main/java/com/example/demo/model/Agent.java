package com.example.demo.model;


public class Agent {

	
	private Long id;
	
	private Renter renter;
	
	private String name;

	private String surname;
	
	private String address;
	
	private String phone;
	
	private Company company;
	
	public Agent() {
		
	}

	public Agent(Renter renter, String name, String surname, String address, String phone) {
		super();
		this.renter = renter;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
