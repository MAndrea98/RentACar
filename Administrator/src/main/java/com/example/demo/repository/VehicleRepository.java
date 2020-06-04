package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	public List<Vehicle> findAll();

	public Optional<Vehicle> findById(Long id);
	
	@SuppressWarnings("unchecked")
	public Vehicle save(Vehicle v);
	
	public void delete(Vehicle v);
}
