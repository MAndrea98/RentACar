package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.UserModel;

@RequestMapping("/admin")
public class AdminController {

	@PutMapping("/acceptComment")
	public ResponseEntity<String> acceptComment() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/declineComment")
	public ResponseEntity<String> declineComment() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/blockUser")
	public ResponseEntity<String> blockUser() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/activateUser")
	public ResponseEntity<String> activateUser(UserModel u) {
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser() {
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
