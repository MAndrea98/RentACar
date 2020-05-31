package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.EndUser;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.service.EndUserService;
import com.example.demo.service.UserModelService;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private EndUserService endUserService;
	
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
	
	@PostMapping("/registerAgent")
	public ResponseEntity<String> registerAgent() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/definePermission")
	public ResponseEntity<String> definePermissions() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
