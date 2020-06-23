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
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private VehicleClass vehicleClass;
	
	@Column(name="mileage")
	private int mileage;
	
	@Column(name="proposedMileage")
	private int proposedMileage;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
	private Renter owner;
	
	@Column(name="cdw")
	private Boolean cdw;
	
	@Column(name="ChildSeatsNo")
	private int childSeatsNo;
	
	@ManyToMany
	@JoinTable(name = "vehicles_requests", joinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "request_id", referencedColumnName = "id"))
	private List<Request> requests = new ArrayList<Request>();

	public Vehicle() {

	}

	public Vehicle(Long id, VehicleClass vehicleClass, int mileage, int proposedMileage, Renter owner, Boolean cdw,
			int childSeatsNo) {
		super();
		this.id = id;
		this.vehicleClass = vehicleClass;
		this.mileage = mileage;
		this.proposedMileage = proposedMileage;
		this.owner = owner;
		this.cdw = cdw;
		this.childSeatsNo = childSeatsNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getProposedMileage() {
		return proposedMileage;
	}

	public void setProposedMileage(int proposedMileage) {
		this.proposedMileage = proposedMileage;
	}

	public Renter getOwner() {
		return owner;
	}

	public void setOwner(Renter owner) {
		this.owner = owner;
	}

	public Boolean getCdw() {
		return cdw;
	}

	public void setCdw(Boolean cdw) {
		this.cdw = cdw;
	}

	public int getChildSeatsNo() {
		return childSeatsNo;
	}

	public void setChildSeatsNo(int childSeatsNo) {
		this.childSeatsNo = childSeatsNo;
	}

	

}
