package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.GasType;

public interface GasTypeRepository extends JpaRepository<GasType, Long>{

}
