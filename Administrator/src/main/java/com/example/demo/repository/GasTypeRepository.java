package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.GasType;

public interface GasTypeRepository extends JpaRepository<GasType, Long>{

	public List<GasType> findAll();
	
	@SuppressWarnings("unchecked")
	public GasType save(GasType g);
	
	public Optional<GasType> findById(Long id);
	
	public void delete(GasType g);
	
	public void flush();
}
