package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ad;
import com.example.demo.model.Request;
import com.example.demo.service.RequestService;

@RestController
@RequestMapping(value = "/request")
@CrossOrigin
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@GetMapping(value = "/getAds/{id}")
	public ResponseEntity<List<Ad>> ads(@PathVariable("id") Long id) {
		Request request = requestService.findById(id);
		return new ResponseEntity<List<Ad>>(request.getAds(), HttpStatus.OK);
	}
}
