package com.example.demo.controller;

import java.util.ArrayList;

import javax.ws.rs.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ad;

@RestController
@RequestMapping("/search")
public class SearchController {

	@GetMapping("/{ad}")
	public ResponseEntity<Ad> getAd(@PathParam("ad") Long id){
		
		return new ResponseEntity<Ad>(new Ad(), HttpStatus.OK);
	}
	
	@GetMapping("/findAds")
	public ResponseEntity<ArrayList<Ad>> findAd(Ad ad){
		
		return new ResponseEntity<ArrayList<Ad>>(new ArrayList<Ad>(), HttpStatus.OK);
	}
	
	
}
