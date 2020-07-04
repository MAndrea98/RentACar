package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public Cart findByEndUserID(Long id) {
		return cartRepository.findByEndUserID(id);
	}

	public Cart save(Cart cart) {
		return cartRepository.saveAndFlush(cart);
	}
}
