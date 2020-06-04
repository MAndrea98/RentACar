package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.GasType;
import com.example.demo.model.Manufacturer;
import com.example.demo.model.Model;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleClass;
import com.example.demo.service.GasTypeService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.ModelService;
import com.example.demo.service.UserModelService;
import com.example.demo.service.VehicleClassService;
import com.example.demo.service.VehicleService;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleClassService vehicleClassService;
	
	@Autowired
	private ModelService modelService;
		
	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private GasTypeService gasTypeService;
	

	
	@PutMapping("/acceptComment")
	public ResponseEntity<String> acceptComment() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/declineComment")
	public ResponseEntity<String> declineComment() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/blockUser")
	public ResponseEntity<String> blockUser(HttpEntity<String> json) throws ParseException {
		String jString = json.getBody();
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject)parser.parse(jString);
		String username = (String)jObj.get("username");
		
		Optional<UserModel> ou = userModelService.findByUsername(username);
		UserModel u = null;
		if(ou.get() != null)
			u = ou.get();
		else
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
		u.setUloga(UserType.BLOCKED);
		userModelService.save(u);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/activateUser")
	public ResponseEntity<String> activateUser(HttpEntity<String> json) throws ParseException {
		String jString = json.getBody();
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject)parser.parse(jString);
		String username = (String)jObj.get("username");
		String role = (String)jObj.get("role");
		
		Optional<UserModel> ou = userModelService.findByUsername(username);
		UserModel u = null;
		if(ou.get() != null)
			u = ou.get();
		else
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
		switch(role) {
		case "Renter":
			u.setUloga(UserType.RENTER);
			break;
		case "Agent":
			u.setUloga(UserType.AGENT);
			break;
		case "Company":
			u.setUloga(UserType.COMPANY);
			break;
		case "Admin":
			u.setUloga(UserType.ADMIN);
			break;
		default:
			u.setUloga(UserType.NOT_ACTIVE);	
		}
		
		userModelService.save(u);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(HttpEntity<String> json) throws ParseException {
		String jString = json.getBody();
		@SuppressWarnings("deprecation")
		JSONParser parser = new JSONParser();
		JSONObject jObj = (JSONObject)parser.parse(jString);
		String username = (String)jObj.get("username");
		
		Optional<UserModel> ou = userModelService.findByUsername(username);
		UserModel u = null;
		if(ou.get() != null)
			u = ou.get();
		else
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
		u.setUloga(UserType.REMOVED);
		userModelService.save(u);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/getIDs")
	public ResponseEntity<HashMap<Long, String>> getIDs(){
		HashMap<Long, String> retVal = new HashMap<Long, String>();
		
		List<GasType> gasTypes = gasTypeService.findAll();
		List<Manufacturer> manufacturers = manufacturerService.findAll();
		List<Model> models = modelService.findAll();
		List<Vehicle> vehicles = vehicleService.findAll();
	
		for(GasType g : gasTypes) {
			retVal.put(g.getId(), g.getName());
		}
		
		for(Manufacturer m : manufacturers) {
			retVal.put(m.getId(), m.getName());
		}
		
		for(Model m : models) {
			retVal.put(m.getId(), m.getName());
		}
		
		for(Vehicle v : vehicles) {
			retVal.put(v.getId(), v.getVehicleClass().getName());
		}
		
		
		
		
		return new ResponseEntity<HashMap<Long, String>>(retVal, HttpStatus.OK);
	}
	
	@PostMapping("/vehicle")
	public ResponseEntity<String> newVehicle(Vehicle v){
		
		Vehicle v1 = new Vehicle(v);
		vehicleService.save(v1);
		return new ResponseEntity<String>("Vehicle added", HttpStatus.OK);
	}
	
	@PostMapping("/vehicleClass")
	public ResponseEntity<String> newVehicleClass(VehicleClass v){
		VehicleClass v1 = new VehicleClass(v);
		vehicleClassService.save(v1);
		
		return new ResponseEntity<String>("Vehicle class added", HttpStatus.OK);
	}
	
	@PostMapping("/model")
	public ResponseEntity<String> newModel(Model m){
		Model m1 = new Model(m);
		modelService.save(m1);
		
		return new ResponseEntity<String>("Model added", HttpStatus.OK);
	}
	
	@PostMapping("/manufacturer")
	public ResponseEntity<String> newManufacturer(Manufacturer m){
		Manufacturer m1 = new Manufacturer(m);
		manufacturerService.save(m1);
		
		return new ResponseEntity<String>("Manufacturer added", HttpStatus.OK);
		
	}
	
	@PostMapping("/gasType")
	public ResponseEntity<String> newGasType(GasType g){
		GasType g1 = new GasType(g);
		gasTypeService.save(g1);
		
		return new ResponseEntity<String>("GasType added", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/vehicle")
	public ResponseEntity<String> deleteVehicle(Vehicle v){
		Vehicle v1 = vehicleService.findById(v.getId()).get();
		vehicleService.delete(v1);
		
		return new ResponseEntity<String>("Vehicle deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/vehicleClass")
	public ResponseEntity<String> deleteVehicleClass(VehicleClass v){
		VehicleClass v1 = vehicleClassService.findById(v.getId()).get();
		vehicleClassService.delete(v1);
		
		return new ResponseEntity<String>("Vehicle class deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/model")
	public ResponseEntity<String> deleteModel(Model m){
		Model m1 = modelService.findById(m.getId()).get();
		modelService.delete(m1);
		
		return new ResponseEntity<String>("Model deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/manufacturer")
	public ResponseEntity<String> deleteManufacturer(Manufacturer m){
		Manufacturer m1 = manufacturerService.findById(m.getId()).get();
		manufacturerService.delete(m1);
		
		return new ResponseEntity<String>("Manufacturer deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/gasType")
	public ResponseEntity<String> deleteGasType(GasType g){
		GasType g1 = gasTypeService.findById(g.getId()).get();
		gasTypeService.delete(g1);
		
		return new ResponseEntity<String>("Gas type deleted", HttpStatus.OK);
	}

	@PostMapping("/registerAgent")
	public ResponseEntity<String> registerAgent() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/definePermission")
	public ResponseEntity<String> definePermissions() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
