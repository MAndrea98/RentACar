package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ad;
import com.example.demo.repository.AdRepository;

@Service
public class AdService {

	@Autowired
	private static AdRepository adRepository;

	public Ad save(Ad ad) {
		return adRepository.save(ad);
	}

	public static List<Ad> findAll(){
		return adRepository.findAll();
	}
}
