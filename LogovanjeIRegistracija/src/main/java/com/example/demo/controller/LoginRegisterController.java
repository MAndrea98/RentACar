package com.example.demo.controller;

import javax.ws.rs.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;

@RestController
@RequestMapping("/login")
public class LoginRegisterController {

	@PostMapping("/register")
	public ResponseEntity<UserModel> registerUser(){
		
		return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.OK);
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
