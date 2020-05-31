package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, Long>{

	Optional<UserModel> findById(Long id);
	
	Optional<UserModel> findByUsername(String u);
	
	
	@SuppressWarnings("unchecked")
	UserModel save(UserModel u);
}
