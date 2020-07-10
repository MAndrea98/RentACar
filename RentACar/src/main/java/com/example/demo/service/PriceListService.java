package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PriceList;
import com.example.demo.repository.PriceListRepository;

@Service
public class PriceListService {
	@Autowired
	PriceListRepository priceListRepository;
	
	public PriceList save(PriceList p) {
		return priceListRepository.save(p);
	}
	
}
