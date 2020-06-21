package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EndUser;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

	// TODO uraditi @Query
	Request findByRenterAndEndUserAndStatus(Renter renter, EndUser endUser, String status);
}
