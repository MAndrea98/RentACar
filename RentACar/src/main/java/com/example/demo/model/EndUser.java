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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EndUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idUser", nullable = false, unique = true)
	private Long idUser;
		
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@JsonIgnore
	@OneToMany(mappedBy="endUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<Review>();
	
	@JsonIgnore
	@ManyToMany
	private List<Ad> favorites = new ArrayList<Ad>();
	
	@JsonIgnore
	@OneToMany(mappedBy="endUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> requsets = new ArrayList<Request>();
	
	public EndUser() {
		
	}

	public EndUser(Long idUser, String name, String surname, String address, String phone, List<Review> reviews,
			List<Ad> favorites, List<Request> requsets) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.reviews = reviews;
		this.favorites = favorites;
		this.requsets = requsets;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Ad> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Ad> favorites) {
		this.favorites = favorites;
	}

	public List<Request> getRequsets() {
		return requsets;
	}

	public void setRequsets(List<Request> requsets) {
		this.requsets = requsets;
	}
	
	

}
