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
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private EndUser endUser;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "requests")
	private List<Ad> ads = new ArrayList<Ad>();
	
	@Column(name="status")
	private RequestStatus status;
	

	public Request() {

	}

	public Request(Long id, EndUser endUser, List<Ad> ads, RequestStatus status) {
		super();
		this.id = id;
		this.ads = ads;
		this.endUser = endUser;
		this.status = status;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EndUser getEndUser() {
		return endUser;
	}

	public void setEndUser(EndUser endUser) {
		this.endUser = endUser;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", endUser=" + endUser + ", ads=" + ads + ", status=" + status + "]";
	}
	
	

}
