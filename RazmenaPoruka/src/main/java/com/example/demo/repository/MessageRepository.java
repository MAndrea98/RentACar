package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Message;
import com.example.demo.model.Request;

public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByRequest(Request request);
}
