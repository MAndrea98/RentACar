package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;



public class Vehicle {
	
	private Long id;

	private Byte[] image;
	
	private Model model;
	
	private GasType gasType;
	
	private String gearBox;
	
	private VehicleClass vehicleClass;
	
	private PriceList price;
	
	private int mileage;
	
	private int proposedMileage;
	
	private Renter owner;
	
	private Boolean cdw;
	
	private int childSeatsNo;
	
	private List<Request> requests = new ArrayList<Request>();
	
	public Vehicle() {
		
	}
	
	public Vehicle(Byte[] image, Model model, GasType gasType, String gearBox, VehicleClass vehicleClass,
			PriceList price, int mileage, int proposedMileage, Renter owner, Boolean cdw, int childSeatsNo) {
		super();
		this.image = image;
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

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
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
	
	
}
