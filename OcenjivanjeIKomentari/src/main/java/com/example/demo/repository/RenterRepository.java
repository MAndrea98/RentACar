package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Renter;

public interface RenterRepository extends JpaRepository<Renter, Long>{

	Optional<Renter> findByIdUser(Long idUser);

}
