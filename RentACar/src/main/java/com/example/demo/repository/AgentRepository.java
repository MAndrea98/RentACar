package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Agent;

public interface AgentRepository extends JpaRepository<Agent,Long> {

	@Override
	Page<Agent> findAll(Pageable pageable);
}
