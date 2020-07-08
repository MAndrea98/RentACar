package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserModelService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserModelService userModelService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable("id") Long id) {
		System.out.println("###" + id);
		UserModel userModel = userModelService.findById(id);
		System.out.println(userModel);
		return new ResponseEntity<UserModel>(userModel, HttpStatus.OK);
	}
}
