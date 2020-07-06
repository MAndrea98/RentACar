package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EndUser;
import com.example.demo.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

	List<Request> findByEndUser(EndUser endUser);

}
