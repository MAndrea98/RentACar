package com.example.demo.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Renter;
import com.example.demo.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Page<Vehicle> findAll(Pageable pageable);
	
	Vehicle findByOwner(Renter owner);
	
	//Optional<Vehicle> findById(Long id);

}
