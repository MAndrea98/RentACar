package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Cart;
import com.example.demo.model.GasType;
import com.example.demo.model.Model;
import com.example.demo.model.PriceList;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleClass;

public class VehicleDTO {

	private Long id;
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
	private List<Cart> carts = new ArrayList<Cart>();
	
	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleDTO(Long id, Model model, GasType gasType, String gearBox, VehicleClass vehicleClass, PriceList price,
			int mileage, int proposedMileage, Renter owner, Boolean cdw, int childSeatsNo, List<Request> requests,
			List<Cart> carts) {
		super();
		this.id = id;
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
		this.requests = requests;
		this.carts = carts;
	}
	
	public VehicleDTO(Vehicle v) {
		this(v.getId(), v.getModel(), v.getGasType(), v.getGearBox(), v.getVehicleClass(), v.getPrice(), v.getMileage(), 
				v.getProposedMileage(), v.getOwner(), v.getCdw(), v.getChildSeatsNo(), v.getRequests(), v.getCarts());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
