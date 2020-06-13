package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ad;
import com.example.demo.model.Request;
import com.example.demo.model.Search;
import com.example.demo.model.Vehicle;
import com.example.demo.service.AdService;
import com.example.demo.service.RequestService;

@RestController
@RequestMapping(value="/ad")
public class AdController {

	AdService adService;
	RequestService requestService;

	@PostMapping(value="/create")
	public ResponseEntity<String> createAd(@RequestBody Ad ad) {
		if(ad.equals(null)) {
			return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
		}

		Ad newAd = new Ad();
		newAd.setDate(ad.getDate());
		HashMap<Calendar,Boolean> newFree = (HashMap<Calendar, Boolean>) ad.getFree();
		newAd.setFree(newFree);
		newAd.setMileage(ad.getMileage());
		newAd.setUser(ad.getUser());
		newAd.setValidFrom(ad.getValidFrom());
		newAd.setValidTru(ad.getValidTru());
		newAd.setVehicle(ad.getVehicle());

		adService.save(newAd);
		return new ResponseEntity<String>("",HttpStatus.OK);

	}

	@PostMapping(value="/occupy")
	public ResponseEntity<String> occupy(@RequestBody Date dateFrom, @RequestBody Date dateTo, @RequestBody Ad ad){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFrom);
		calendar.setTime(dateTo);

		ad.getFree().put(calendar, false);

		Vehicle vehicle = ad.getVehicle();
		List<Request> list = requestService.findAll();
		for(Request r : list) {
			for(Vehicle v : r.getVehicles()) {
				if(v.getId() == vehicle.getId() && r.getStatus() == "PENDING") {
					r.setStatus("CANCELED");
				}
			}
		}

		return new ResponseEntity<String>("",HttpStatus.OK);
	}

	@PostMapping(value="/search")
	public List<Ad> search(@RequestBody Search search){

		List<Ad> listOfAds = AdService.findAll();
		List<Ad> listOfFoundAds = new ArrayList<Ad>();
		for(Ad a : listOfAds) {
			if(a.getPlace() == search.getPlace() && search.getDateFrom().before(a.getDateFrom()) && a.getDateTo().before(search.getDateTo())) {
				listOfFoundAds.add(a);
			}
		}
		return listOfFoundAds;

	}
}
