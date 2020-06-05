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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<VehicleImage> images = new ArrayList<VehicleImage>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Model model;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private GasType gasType;
	
	@Column(name="gearBox")
	private String gearBox;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private VehicleClass vehicleClass;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PriceList price;
	
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
	
	@ManyToMany
	@JoinTable(name = "vehicles_carts", joinColumns = @JoinColumn(name = "vehicle_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"))
	private List<Cart> carts = new ArrayList<Cart>();
	
	public Vehicle() {
		
	}
	
	public Vehicle(Model model, GasType gasType, String gearBox, VehicleClass vehicleClass,
			PriceList price, int mileage, int proposedMileage, Renter owner, Boolean cdw, int childSeatsNo) {
		super();
		this.model = model;
		this.gasType = gasType;
		this.gearBox = gearBox;
		this.vehicleClass = vehicleClass;
		this.price = price;
		this.mileage = mileage;
		this.proposedMileage = proposedMileage;
		this.owner = owner;
		this.cdw = cdw;
		this.childSeatsNo = childSeatsNo;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public GasType getGasType() {
		return gasType;
	}

	public void setGasType(GasType gasType) {
		this.gasType = gasType;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public VehicleClass getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(VehicleClass vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	public PriceList getPrice() {
		return price;
	}

	public void setPrice(PriceList price) {
		this.price = price;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	
	
	
	
}
