package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EndUser;

public interface EndUserRepostiory extends JpaRepository<EndUser, Long> {

}
