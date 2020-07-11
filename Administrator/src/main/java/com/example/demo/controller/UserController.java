package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.LoggedUser;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.service.EndUserService;
import com.example.demo.service.UserModelService;

//@RefreshScope
@RequestMapping("/user")
@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserModelService userModelService;
	
	@Autowired
	private EndUserService endUserService;
	
	@PostMapping("/sign_up")
	public ResponseEntity<UserModel> signUp(){
		
		return new ResponseEntity<UserModel>(new UserModel(), HttpStatus.OK);
	}
	
	@PostMapping("/log_in")
	public ResponseEntity<String> logIn(@RequestBody UserModel userModel){
		
		Optional<UserModel> ou = userModelService.findByUsername(userModel.getUsername());
		UserModel u = null;
		if(ou.get() == null)
			return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
		else
			u = ou.get();
		
		String password = userModel.getPassword();
		
		if(u.getUloga() == UserType.NOT_ACTIVE || u.getUloga() ==UserType.REMOVED)
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		
		if(u.getPassword().equals(password)) {
			LoggedUser.getInstance().setId(u.getId());
		}
		
		/*ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		String url = "http://localhost:8084/call/login";
		restTemplate.postForEntity(url, u.getId(), String.class);
		url = "http://localhost:8089/call/login";
		restTemplate.postForEntity(url, u.getId(), String.class);
		url = "http://localhost:8083/call/login";
		restTemplate.postForEntity(url, u.getId(), String.class);*/
		
		return new ResponseEntity<String>("Logged in", HttpStatus.OK);
	}
	
	@GetMapping("/log_out")
	public ResponseEntity<String> logout(){
		
		LoggedUser loggedUser = LoggedUser.getInstance();
		loggedUser.setId(null);
		
		return new ResponseEntity<String>("Logged out", HttpStatus.OK);
	}

}
