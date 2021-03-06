package com.example.demo.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Agent;
import com.example.demo.model.Company;
import com.example.demo.model.Renter;
import com.example.demo.service.AgentService;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:4200")
public class LoginRegisterController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	AgentService agentService;
	
	@PostMapping("/registerCompany")
	public ResponseEntity<String> registerUser(@RequestBody Company c){
		System.err.println(c.getName() + " " + c.getAddress() + " " + c.getPoslovniMaticniBroj());
		c.setRenter(new Renter());
		List<Company> registered = companyService.findAll();
		for(Company comp:registered) {
			if(comp.getPoslovniMaticniBroj().equals(c.getPoslovniMaticniBroj())) {
				String err = "Kompanija je vec registrovana!";
				System.out.println(err);
				return new ResponseEntity<String>(err,HttpStatus.CONFLICT);
			}
		}
		companyService.save(c);
		return new ResponseEntity<String>("Registration successful",HttpStatus.OK);
	}
	
	@PostMapping("/registerAgent/{poslovniMaticniBroj}")
	public ResponseEntity<String> registerAgent(@RequestBody Agent a, @PathVariable("poslovniMaticniBroj") String poslovniMaticniBroj) {
		List<Agent> registered = agentService.findAll();
		System.err.println(a.getName() + " " + a.getSurname() + " " + a.getAddress() + " " + poslovniMaticniBroj);
		try {
			Company c = companyService.findByPoslovniMaticniBroj(poslovniMaticniBroj);
			a.setCompany(c);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		
		for(Agent ag:registered) {
			if(ag.getName().equals(a.getName()) && ag.getSurname().equals(a.getSurname())) {
				System.out.println("Agent je vec registrovan!");
				return new ResponseEntity<String>(HttpStatus.CONFLICT);
			}
		}
		
		agentService.save(a);
		return new ResponseEntity<String>(a.getId().toString(), HttpStatus.OK);
	}
	
	@PostMapping("/{user}")
	public ResponseEntity<String> login(@PathParam("user") String username){
		
		return new ResponseEntity<String>("Logged in", HttpStatus.OK);
	}
	
	@PutMapping("/change_data/{user}")
	public ResponseEntity<String> changeData(@PathParam("user") String username){
		
		return new ResponseEntity<String>("Edited data", HttpStatus.OK);
	}
	
	@DeleteMapping("/remove_user/{user}")
	public ResponseEntity<String> deleteUser(@PathParam("user") String username){
		
		return new ResponseEntity<String>("Deleted user", HttpStatus.OK);
	}
	
	@PostMapping("/logout/{user}")
	public ResponseEntity<String> logout(@PathParam("user") String username){
		
		return new ResponseEntity<String>("Logged out", HttpStatus.OK);
	}
}
