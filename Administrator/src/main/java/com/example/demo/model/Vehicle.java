package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
	private Renter owner;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Model model;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private GasType gasType;
	
	@Column(name="gearBox")
	private String gearBox;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private VehicleClass vehicleClass;
	
	@Column(name="mileage")
	private int mileage;
	
	@Column(name="proposedMileage")
	private int proposedMileage;
	
	@Column(name="cdw")
	private Boolean cdw;
	
	@Column(name="ChildSeatsNo")
	private int childSeatsNo;
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<VehicleFree> vehicleFree = new HashSet<VehicleFree>();
	
	@JsonIgnore
	@OneToMany(mappedBy="vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PriceList> priceList = new HashSet<PriceList>();
	
	public Vehicle() {
		
	}
	
	public Vehicle(Model model, GasType gasType, String gearBox, VehicleClass vehicleClass,
			int mileage, int proposedMileage, Renter owner, Boolean cdw, int childSeatsNo) {
		super();
		this.model = model;
		this.gasType = gasType;
		this.gearBox = gearBox;
		this.vehicleClass = vehicleClass;
		this.mileage = mileage;
		this.proposedMileage = proposedMileage;
		this.owner = owner;
		this.cdw = cdw;
		this.childSeatsNo = childSeatsNo;
	}
	
	public Vehicle (Vehicle v) {
		this(v.getModel(), v.getGasType(), v.getGearBox(), v.getVehicleClass(), v.getMileage(),
				v.getProposedMileage(), v.getOwner(), v.getCdw(), v.getChildSeatsNo());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<VehicleImage> getImages() {
		return images;
	}

	public void setImages(List<VehicleImage> images) {
		this.images = images;
	}

	public Renter getOwner() {
		return owner;
	}

	public void setOwner(Renter owner) {
		this.owner = owner;
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

	public Set<VehicleFree> getVehicleFree() {
		return vehicleFree;
	}

	public void setVehicleFree(Set<VehicleFree> vehicleFree) {
		this.vehicleFree = vehicleFree;
	}

	public Set<PriceList> getPriceList() {
		return priceList;
	}

	public void setPriceList(Set<PriceList> priceList) {
		this.priceList = priceList;
	}

	
}
