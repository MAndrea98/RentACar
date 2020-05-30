package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Vehicle;

public interface VehicleClassRepository extends JpaRepository<Vehicle, Long> {

}
