package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdDTO;
import com.example.demo.model.Ad;

@RestController
@RequestMapping("/ad")
public class AdController {

	@PostMapping(value = "/new")
	public ResponseEntity<String> newAd() {
		return new ResponseEntity<String>("Created", HttpStatus.CREATED);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Ad>> getAllAd() {
		return new ResponseEntity<List<Ad>>(new ArrayList<Ad>(), HttpStatus.OK);
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<AdDTO> editAd() {
		return new ResponseEntity<AdDTO>(new AdDTO(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteAd() {
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}
}
