package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Manufacturer;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{

	public List<Manufacturer> findAll();
	
	@SuppressWarnings("unchecked")
	public Manufacturer save(Manufacturer m);
	
	public Optional<Manufacturer> findById(Long id);
	
	public void delete(Manufacturer m);
	
	public void flush();
}
