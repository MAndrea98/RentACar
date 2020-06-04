package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.VehicleClass;

public interface VehicleClassRepository extends JpaRepository<VehicleClass, Long> {

	public List<VehicleClass> findAll();
}
