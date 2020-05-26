package com.example.demo.model;

public class EndUser {

	private Long id;

	private Long idUser;

	private String name;

	private String surname;

	private String address;

	private String phone;

	public EndUser() {

	}

	public EndUser(Long idUser, String name, String surname, String address, String phone) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

}
