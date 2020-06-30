package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PriceList;
import com.example.demo.repository.PriceListRepository;

@Service
public class PriceListService {

	@Autowired
	private PriceListRepository priceListRepository;
	
	public PriceList save(PriceList priceList) {
		return priceListRepository.save(priceList);
	}

	public PriceList findById(Long id) {
		return priceListRepository.findById(id).orElse(null);
	}

	public List<PriceList> findAll() {
		return priceListRepository.findAll();
	}

	public void delete(Long id) {
		priceListRepository.deleteById(id);
	}
}
