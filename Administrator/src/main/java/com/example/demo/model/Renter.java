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
public class Renter {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idUser", nullable = false, unique = true)
	private Long idUser;
	
	@OneToMany(mappedBy="owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@OneToOne(fetch = FetchType.LAZY)
	private PriceList priceList;

	@JsonIgnore
	@OneToMany(mappedBy="renter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<Review>();

	public Renter() {

	}

	public Renter(UserModel user, List<Vehicle> vehicles, PriceList priceList,
			List<Review> reviews) {
		super();
		this.vehicles = vehicles;
		this.priceList = priceList;
		this.reviews = reviews;
	}



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


}
