package com.example.demo.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.model.Cart;
import com.example.demo.model.GasType;
import com.example.demo.model.Model;
import com.example.demo.model.PriceList;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleClass;
import com.example.demo.model.VehicleFree;

public class VehicleDTO {

	private Long id;
	private Renter owner;
	private Model model;
	private GasType gasType;
	private String gearBox;
	private VehicleClass vehicleClass;
	private int mileage;
	private int proposedMileage;
	private Boolean cdw;
	private int childSeatsNo;
	private Set<VehicleFree> vehicleFree = new HashSet<VehicleFree>();
	private List<Request> requests = new ArrayList<Request>();
	private List<Cart> carts = new ArrayList<Cart>();
	private Set<PriceList> priceList = new HashSet<PriceList>();
	
	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public VehicleDTO(Long id, Renter owner, Model model, GasType gasType, String gearBox, VehicleClass vehicleClass,
			int mileage, int proposedMileage, Boolean cdw, int childSeatsNo,
			Set<VehicleFree> vehicleFree, List<Request> requests, List<Cart> carts, Set<PriceList> priceList) {
		super();
		this.id = id;
		this.owner = owner;
		this.model = model;
		this.gasType = gasType;
		this.gearBox = gearBox;
		this.vehicleClass = vehicleClass;
		this.mileage = mileage;
		this.proposedMileage = proposedMileage;
		this.cdw = cdw;
		this.childSeatsNo = childSeatsNo;
		this.vehicleFree = vehicleFree;
		this.requests = requests;
		this.carts = carts;
		this.priceList = priceList;
	}



	public VehicleDTO(Vehicle v) {
		this(v.getId(), v.getOwner(), v.getModel(), v.getGasType(), v.getGearBox(), v.getVehicleClass(), v.getMileage(),
				v.getProposedMileage(), v.getCdw(), v.getChildSeatsNo(), v.getVehicleFree(), v.getRequests(), 
				v.getCarts(), v.getPriceList());
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
