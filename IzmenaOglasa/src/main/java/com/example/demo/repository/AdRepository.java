package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {

	Page<Ad> findAll(Pageable pageable);

	//Optional<Ad> findById(Long id);
}
