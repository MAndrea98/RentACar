package com.example.demo.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LogedUser;

@RefreshScope
@RestController
@RequestMapping(value = "/call")
@CrossOrigin
public class ComunicationController {

	@PostMapping(value = "/login")
	public ResponseEntity<String> setLogedUser(@RequestBody Long id) {
		LogedUser.getInstance().setUserId(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
