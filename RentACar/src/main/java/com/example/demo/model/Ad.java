package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	private Vehicle vehicle;

	@Column(name="place")
	private String place;

	@Column(name="date", nullable = false)
	private Calendar date;

	@Column(name="validTru", nullable = false)
	private Calendar validTru;

	@Column(name="validFrom", nullable = false)
	private Calendar validFrom;

	@Column(name="dateFrom", nullable = false)
	private Calendar dateFrom;

	@Column(name="dateTo", nullable = false)
	private Calendar dateTo;

	@OneToMany(mappedBy="ad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> listOfReviews = new ArrayList<Review>();

	@Column(name="number_of_reviews")
	private int numberOfReviews = listOfReviews.size();

	@ManyToMany
	private List<EndUser> favoriteFor;
	
	@Column(name="mileageLimit")
	private int mileageLimit;
	
	@JsonIgnore
	@ManyToMany( cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "ads_requests", joinColumns = @JoinColumn(name = "ad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "request_id", referencedColumnName = "id"))
	private List<Request> requests = new ArrayList<Request>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "ads_carts", joinColumns = @JoinColumn(name = "ad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"))
	private List<Cart> carts = new ArrayList<Cart>();
	
	public Ad() {

	}

	public Ad(Long id, Vehicle vehicle, String place, Calendar date, Calendar validTru, Calendar validFrom,
			Calendar dateFrom, Calendar dateTo, List<Request> requests) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.place = place;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.requests = requests;
	}

	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getValidTru() {
		return validTru;
	}

	public void setValidTru(Calendar validTru) {
		this.validTru = validTru;
	}

	public Calendar getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Calendar validFrom) {
		this.validFrom = validFrom;
	}

	public Calendar getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Calendar getDateTo() {
		return dateTo;
	}

	public void setDateTo(Calendar dateTo) {
		this.dateTo = dateTo;
	}

	public List<EndUser> getFavoriteFor() {
		return favoriteFor;
	}

	public void setFavoriteFor(List<EndUser> favoriteFor) {
		this.favoriteFor = favoriteFor;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public List<Review> getListOfReviews() {
		return listOfReviews;
	}

	public void setListOfReviews(List<Review> listOfReviews) {
		this.listOfReviews = listOfReviews;
	}

	public int getNumberOfReviews() {
		return numberOfReviews;
	}

	public void setNumberOfReviews(int numberOfReviews) {
		this.numberOfReviews = numberOfReviews;
	}

	public int getMileageLimit() {
		return mileageLimit;
	}

	public void setMileageLimit(int mileageLimit) {
		this.mileageLimit = mileageLimit;
	}

	@Override
	public String toString() {
		return "Ad [id=" + id + ", vehicle=" + vehicle + ", place=" + place + ", date=" + date + ", validTru="
				+ validTru + ", validFrom=" + validFrom + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ ", listOfReviews=" + listOfReviews + ", numberOfReviews=" + numberOfReviews + ", favoriteFor="
				+ favoriteFor + ", mileageLimit=" + mileageLimit + ", requests=" + requests + ", carts=" + carts + "]";
	}

	

}
