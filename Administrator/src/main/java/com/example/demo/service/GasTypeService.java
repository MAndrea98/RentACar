package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GasType;
import com.example.demo.repository.GasTypeRepository;

@Service
public class GasTypeService {

	@Autowired
	private GasTypeRepository gasTypeRepository;
	
	public List<GasType> findAll(){
		return gasTypeRepository.findAll();
	}
}
