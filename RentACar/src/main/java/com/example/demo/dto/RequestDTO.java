package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Ad;
import com.example.demo.model.EndUser;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;

public class RequestDTO {
	
	private Long id;
	private EndUser endUser;
	private List<Ad> ads = new ArrayList<Ad>();
	private RequestStatus status;
	
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDTO(Long id, EndUser endUser, List<Ad> ads, RequestStatus status) {
		super();
		this.id = id;
		this.endUser = endUser;
		this.ads = ads;
		this.status = status;
	}
	
	public RequestDTO(Request r) {
		this(r.getId(), r.getEndUser(), r.getAds(), r.getStatus());
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

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}
	
	
}
