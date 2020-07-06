package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VehicleClass;

public interface VehicleClassRepository extends JpaRepository<VehicleClass, Long> {

	public List<VehicleClass> findAll();
	
	public Optional<VehicleClass> findById(Long id);
	
	@SuppressWarnings("unchecked")
	public VehicleClass save(VehicleClass v);
	
	public void delete(VehicleClass v);
	
	public void flush();
}
