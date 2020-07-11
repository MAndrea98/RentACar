package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.GasType;
import com.example.demo.model.Manufacturer;
import com.example.demo.model.Model;
import com.example.demo.model.Review;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleClass;
import com.example.demo.service.GasTypeService;
import com.example.demo.service.ManufacturerService;
import com.example.demo.service.ModelService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.UserModelService;
import com.example.demo.service.VehicleClassService;
import com.example.demo.service.VehicleService;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RequestMapping("/admin")
@RestController
@CrossOrigin("http://localhost:4200")
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
	
	@Autowired
	private ReviewService reviewService;

	@GetMapping(value = "/allReview")
	public ResponseEntity<List<ReviewDTO>> getAllReviews() {
		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
		for (Review r : reviewService.findAll()) {
			if (!r.isDeleted()) {
				UserModel endUser = userModelService.findById(r.getEndUser().getIdUser());
				UserModel renter = userModelService.findById(r.getAd().getVehicle().getOwner().getIdUser());
				reviewDTOs.add(new ReviewDTO(r, renter.getUsername(), endUser.getUsername()));
			}
		}
		return new ResponseEntity<List<ReviewDTO>>(reviewDTOs, HttpStatus.OK);
	}

	@PutMapping("/acceptComment")
	public ResponseEntity<ReviewDTO> acceptComment(@RequestBody ReviewDTO reviewDTO) {
		Review review = reviewService.findById(reviewDTO.getId());
		review.setAccepted(true);
		Review r = reviewService.save(review);
		return new ResponseEntity<ReviewDTO>(new ReviewDTO(r), HttpStatus.OK);
	}
	
	@PutMapping("/declineComment")
	public ResponseEntity<String> declineComment(@RequestBody ReviewDTO reviewDTO) {
		Review review = reviewService.findById(reviewDTO.getId());
		reviewService.delete(review);
		return new ResponseEntity<String>("Declined", HttpStatus.OK);
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
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> newModel(@RequestBody Model m){
		Model m1 = new Model();
		System.out.println(m.toString());
		Manufacturer man = manufacturerService.findById(m.getManufacturer().getId()).get();
		m1.setName(m.getName());
		m1.setManufacturer(man);
		modelService.save(m1);
		modelService.flush();
		return new ResponseEntity<String>("Model added", HttpStatus.OK);
	}
	
	@PostMapping("/manufacturer")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> newManufacturer(@RequestBody Manufacturer m){
		Manufacturer m1 = new Manufacturer(m);
		manufacturerService.save(m1);
		
		return new ResponseEntity<String>("Manufacturer added", HttpStatus.OK);
		
	}
	
	@PostMapping("/gasType")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> newGasType(@RequestBody GasType g){
		System.out.println("Name: " + g.getName());
		GasType g1 = new GasType(g);
		gasTypeService.save(g1);
		
		return new ResponseEntity<String>("GasType added", HttpStatus.OK);
		
	}

	@GetMapping("/vehicle")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Vehicle>> getVehicles(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/vehicleClass")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<VehicleClass>> getVehicleClasses(){
		return new ResponseEntity<List<VehicleClass>>(vehicleClassService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/model")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Model>> getModels(){
		return new ResponseEntity<List<Model>>(modelService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/manufacturer")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<Manufacturer>> getManufacturers(){
		return new ResponseEntity<List<Manufacturer>>(manufacturerService.findAll(), HttpStatus.OK);
	}
	@GetMapping("/gasType")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<GasType>> getGasType(){
		return new ResponseEntity<List<GasType>>(gasTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/gasType/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<GasType> getGasTypeById(@PathVariable Long id){
		
		
		return new ResponseEntity<GasType>(gasTypeService.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/vehicle/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id){
		return new ResponseEntity<Vehicle>(vehicleService.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/vehicleClass/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<VehicleClass> getVehicleClassById(@PathVariable Long id){
		return new ResponseEntity<VehicleClass>(vehicleClassService.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/model/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Model> getModelById(@PathVariable Long id){
		return new ResponseEntity<Model>(modelService.findById(id).get(), HttpStatus.OK);
	}
	
	@GetMapping("/manufacturer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable Long id){
		return new ResponseEntity<Manufacturer>(manufacturerService.findById(id).get(), HttpStatus.OK);
	}
	
	
	@PutMapping("/vehicle")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> editVehicle(@RequestBody Vehicle v){
		Vehicle oldV = vehicleService.findById(v.getId()).get();
		oldV.setCdw(v.getCdw());
		oldV.setChildSeatsNo(v.getChildSeatsNo());
		oldV.setGasType(v.getGasType());
		oldV.setGearBox(v.getGearBox());
		oldV.setMileage(v.getMileage());
		oldV.setModel(v.getModel());
		oldV.setOwner(v.getOwner());
		oldV.setPriceList(v.getPriceList());
		oldV.setProposedMileage(v.getProposedMileage());
		oldV.setVehicleClass(v.getVehicleClass());
		oldV.setVehicleFree(v.getVehicleFree());
		
		vehicleService.save(oldV);
		vehicleService.flush();
		
		return new ResponseEntity<String>("Edited vehicle", HttpStatus.OK);
	}
	
	@PutMapping("/vehicleClass")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> editVehicleClass(@RequestBody VehicleClass v){
		VehicleClass oldV = vehicleClassService.findById(v.getId()).get();
		oldV.setName(v.getName());
		
		vehicleClassService.save(oldV);
		vehicleClassService.flush();
		
		return new ResponseEntity<String>("Edited vehicle class", HttpStatus.OK);
	}
	
	@PutMapping("/model")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> editModel(@RequestBody Model m){
		Model oldM = modelService.findById(m.getId()).get();
		
		oldM.setManufacturer(m.getManufacturer());
		oldM.setName(m.getName());
		
		modelService.save(m);
		modelService.flush();
		
		return new ResponseEntity<String>("Edited model", HttpStatus.OK);
	}
	
	@PutMapping("/manufacturer")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> editManufacturer(@RequestBody Manufacturer m){
		Manufacturer oldM = manufacturerService.findById(m.getId()).get();
		
		oldM.setName(m.getName());
		manufacturerService.save(m);
		manufacturerService.flush();
		
		return new ResponseEntity<String>("Edited manufacturer", HttpStatus.OK);
	}
	
	@PutMapping("/gasType")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> editGasType(@RequestBody GasType g){
		System.out.println(g.toString());
		GasType oldGt = gasTypeService.findById(g.getId()).get();
		oldGt.setName(g.getName());
		
		gasTypeService.save(oldGt);
		gasTypeService.flush();
		
		return new ResponseEntity<String>("Edited gas type", HttpStatus.OK);
	}
	
	

	@DeleteMapping("/vehicle")
	public ResponseEntity<String> deleteVehicle(Vehicle v){
		Vehicle v1 = vehicleService.findById(v.getId()).get();
		vehicleService.delete(v1);
		
		return new ResponseEntity<String>("Vehicle deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/vehicleClass/{id}")
	public ResponseEntity<String> deleteVehicleClass(@PathVariable Long id){
		VehicleClass v1 = vehicleClassService.findById(id).get();
		vehicleClassService.delete(v1);
		
		return new ResponseEntity<String>("Vehicle class deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/model")
	public ResponseEntity<String> deleteModel(Model m){
		Model m1 = modelService.findById(m.getId()).get();
		modelService.delete(m1);
		
		return new ResponseEntity<String>("Model deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/manufacturer/{id}")
	public ResponseEntity<String> deleteManufacturer(@PathVariable Long id){
		Manufacturer m1 = manufacturerService.findById(id).get();
		manufacturerService.delete(m1);
		
		return new ResponseEntity<String>("Manufacturer deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("/gasType/{id}")
	public ResponseEntity<String> deleteGasType(@PathVariable Long id ){
		GasType g1 = gasTypeService.findById(id).get();
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
	
	@GetMapping("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<UserModel>> getUsers(){
		
		return new ResponseEntity<List<UserModel>>(userModelService.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<String> blockUser(@PathVariable Long id){
		
		UserModel u = userModelService.findById(id);
		u.setUloga(UserType.BLOCKED);
		userModelService.save(u);
		userModelService.flush();
		return new ResponseEntity<String>("User blocked", HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		UserModel u = userModelService.findById(id);
		u.setUloga(UserType.REMOVED);
		userModelService.save(u);
		userModelService.flush();
		return new ResponseEntity<String>("User removed", HttpStatus.OK);
	}
}
