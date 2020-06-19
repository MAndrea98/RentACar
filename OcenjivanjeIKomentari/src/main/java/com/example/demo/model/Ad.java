package com.example.demo.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	private Renter renter;

	@Column(name="date", nullable = false)
	private Calendar date;

	@Column(name="validTru", nullable = false)
	private Calendar validTru;

	@Column(name="validFrom", nullable = false)
	private Calendar validFrom;

	@ElementCollection
	@JoinTable(name="free", joinColumns=@JoinColumn(name="Id"))
	@MapKeyColumn (name="free_Id")
	@Column(name="value")
	private Map<Calendar, Boolean> free = new HashMap<Calendar, Boolean>();
	
	@JsonIgnore
	@OneToMany(mappedBy="ad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<Review>();

	@Column(name="mileage")
	private int mileage;

	public Ad() {

	}

	public Ad(Renter renter, Calendar date, Calendar validTru, Calendar validFrom,
			HashMap<Calendar, Boolean> free, int mileage) {
		super();
		this.renter = renter;
		this.date = date;
		this.validTru = validTru;
		this.validFrom = validFrom;
		this.free = free;
		this.mileage = mileage;
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

	public void setFree(Map<Calendar, Boolean> free) {
		this.free = free;
	}

	public Renter getUser() {
		return renter;
	}
	public void setUser(Renter renter) {
		this.renter = renter;
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
	public Map<Calendar, Boolean> getFree() {
		return free;
	}
	public void setFree(HashMap<Calendar, Boolean> free) {
		this.free = free;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
