package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PriceListRepository;

@Service
public class PriceListService {

	@Autowired
	private PriceListRepository priceListRepository;
}
