package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comment")
public class CommentController {
	
	@PostMapping("/create")
	public ResponseEntity<String> createComment() {
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<List<String>> getComments() {
		return new ResponseEntity<List<String>>(new ArrayList<String>(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteComment() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	

}
