package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EndUser;

public interface EndUserRepostiory extends JpaRepository<EndUser, Long> {

	Optional<EndUser> findByIdUser(Long id);
	
	Optional<EndUser> findById(Long id);
	
}
