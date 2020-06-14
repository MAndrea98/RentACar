package com.example.demo.dto;

import com.example.demo.model.Review;

public class ReviewDTO {
	
	private Long id;
	

	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ReviewDTO(Long id) {
		super();
		this.id = id;
	}

	public ReviewDTO(Review r) {
		this(r.getId());
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
