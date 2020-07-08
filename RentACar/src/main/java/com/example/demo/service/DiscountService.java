package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Discount;
import com.example.demo.repository.DiscountRepository;

@Service
public class DiscountService {
	
	@Autowired
	DiscountRepository discountRepository;
	
	public Discount save(Discount d) {
		return discountRepository.save(d);
	}

}
