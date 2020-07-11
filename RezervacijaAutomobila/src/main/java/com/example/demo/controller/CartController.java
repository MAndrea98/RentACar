package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdDTO;
import com.example.demo.model.Ad;
import com.example.demo.model.Cart;
import com.example.demo.model.EndUser;
import com.example.demo.service.AdService;
import com.example.demo.service.CartService;
import com.example.demo.service.EndUserService;
import com.example.demo.service.UserModelService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EndUserService endUserService;
	
	@Autowired
	private AdService adService;
	
	@Autowired
	private UserModelService userModelService;

	@GetMapping
	public ResponseEntity<List<AdDTO>> myCart() {
		/*UserModel userModel = userModelService.findById(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(userModel.getId());*/
		EndUser endUser = endUserService.findByIdUser(1L);
		Cart cart =  cartService.findByEndUserID(endUser.getId());
		List<AdDTO> adDTOs = new ArrayList<AdDTO>();
		for (Ad a : cart.getAds()) {
			adDTOs.add(new AdDTO(a));
		}
		return new ResponseEntity<List<AdDTO>>(adDTOs, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> removeFromCart(@PathVariable("id") Long id) {
		/*UserModel userModel = userModelService.findById(LogedUser.getInstance().getUserId());
		EndUser endUser = endUserService.findByIdUser(userModel.getId());*/
		EndUser endUser = endUserService.findByIdUser(1L);
		Cart cart =  cartService.findByEndUserID(endUser.getId());
		for (int i = 0 ; i < cart.getAds().size(); i++) {
			if (cart.getAds().get(i).getId().equals(id)) {
				Ad a = cart.getAds().get(i);
				cart.getAds().remove(cart.getAds().get(i));
				a.getCarts().remove(cart);
				adService.save(a);
			}
		}
		cartService.save(cart);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
