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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "vehicle_id")
	private Long vehicleID;
	
	@JsonIgnore
	@ManyToMany( cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(name = "ads_requests", joinColumns = @JoinColumn(name = "ad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "request_id", referencedColumnName = "id"))
	private List<Request> requests = new ArrayList<Request>();

	@OneToMany(mappedBy="ad", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Review> listOfReviews = new ArrayList<Review>();

	@Column(name="number_of_reviews")
	private int numberOfReviews = listOfReviews.size();

	public Ad() {

	}

	public Ad(Long id, List<Review> listOfReviews, int numberOfReviews) {
		super();
		this.id = id;
		this.listOfReviews = listOfReviews;
		this.numberOfReviews = numberOfReviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
}
