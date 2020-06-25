package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdDTO;
import com.example.demo.model.Ad;
import com.example.demo.service.AdService;

@RestController
@RequestMapping("/ad")
public class AdController {

	@Autowired
	private AdService adService;

	@PostMapping(value = "/new")
	public ResponseEntity<String> createAd(@RequestBody Ad ad) {
		if(ad.equals(null)) {
			return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
		}

		Ad newAd = new Ad();
		newAd.setDate(ad.getDate());
		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(
		/*HashMap<Calendar,Boolean> newFree = (HashMap<Calendar, Boolean>) ad.getFree();
		newAd.setFree(newFree);
		newAd.setMileage(ad.getMileage());
		newAd.setUser(ad.getUser());*/
		newAd.setValidFrom(ad.getValidFrom());
		newAd.setValidTru(ad.getValidTru());
		newAd.setVehicle(ad.getVehicle());

		adService.save(newAd);
		return new ResponseEntity<String>("",HttpStatus.CREATED);

	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<Ad>> getAllAd() {
		return new ResponseEntity<List<Ad>>(new ArrayList<Ad>(), HttpStatus.OK);
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<AdDTO> editAd() {
		return new ResponseEntity<AdDTO>(new AdDTO(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteAd() {
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@PostMapping(value="/changeMileage")
	public ResponseEntity<String> changeMileage(@RequestBody AdDTO adDto, @RequestBody int mileage) {
		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(
		/*Ad ad = adService.findById(adDto.getId());
		ad.setMileage(mileage);
		adService.save(ad);*/

		return new ResponseEntity<String>("",HttpStatus.OK);
	}
}
