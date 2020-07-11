package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{

	public List<Model> findAll();
	
	@SuppressWarnings("unchecked")
	public Model save(Model m);

	public Optional<Model> findById(Long id);
	
	public void delete(Model m);
	
	public void flush();
}
