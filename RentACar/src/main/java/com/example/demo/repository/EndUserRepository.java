package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {

	EndUser findByIdUser(Long idUser);
	
	
}
