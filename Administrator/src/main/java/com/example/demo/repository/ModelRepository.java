package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{

	public List<Model> findAll();
}
