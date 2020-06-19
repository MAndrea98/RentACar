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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Renter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idUser", nullable = false, unique = true)
	private Long idUser;
	
	@JsonIgnore
	@OneToMany(mappedBy="renter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Request> ordered = new ArrayList<Request>();
	
	public Renter() {
		
	}

	public Renter(Long id, Long idUser, List<Request> ordered) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.ordered = ordered;
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

	public List<Request> getOrdered() {
		return ordered;
	}

	public void setOrdered(List<Request> ordered) {
		this.ordered = ordered;
	}

	
}