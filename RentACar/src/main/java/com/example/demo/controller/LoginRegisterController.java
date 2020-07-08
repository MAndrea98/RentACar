package com.example.demo.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Agent;
import com.example.demo.model.Company;
import com.example.demo.service.AgentService;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/login")
public class LoginRegisterController {

	@Autowired
	CompanyService companyService;
	
	@Autowired
	AgentService agentService;
	
	@PostMapping("/registerCompany")
	public ResponseEntity<Company> registerUser(@RequestBody Company c){
		
		List<Company> registered = companyService.findAll();
		for(Company comp:registered) {
			if(comp.getPoslovniMaticniBroj().equals(c.getPoslovniMaticniBroj())) {
				System.out.println("Kompanija je vec registrovana!");
				return new ResponseEntity<Company>(HttpStatus.CONFLICT);
			}
		}
		companyService.save(c);
		return new ResponseEntity<Company>(c, HttpStatus.OK);
	}
	
	@PostMapping("/registerAgent/{poslovniMaticniBroj}")
	public ResponseEntity<Agent> registerAgent(@RequestBody Agent a, @PathParam("poslovniMaticniBroj") String poslovniMaticniBroj) {
		List<Agent> registered = agentService.findAll();
		
		Company c = companyService.findByPoslovniMaticniBroj(poslovniMaticniBroj);
		a.setCompany(c);
		for(Agent ag:registered) {
			if(ag.getName().equals(a.getName()) && ag.getSurname().equals(a.getSurname())) {
				System.out.println("Agent je vec registrovan!");
				return new ResponseEntity<Agent>(HttpStatus.CONFLICT);
			}
		}
		
		agentService.save(a);
		return new ResponseEntity<Agent>(HttpStatus.OK);
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
