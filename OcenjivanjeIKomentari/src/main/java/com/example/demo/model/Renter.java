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

	@OneToOne(fetch = FetchType.LAZY)
	private PriceList priceList;

	@JsonIgnore
	@OneToMany(mappedBy="renter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ad> ads = new ArrayList<Ad>();

	public Renter() {

	}

	public Renter(UserModel user, PriceList priceList, List<Ad> ads) {
		super();
		this.priceList = priceList;
		this.ads = ads;
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

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	

}
