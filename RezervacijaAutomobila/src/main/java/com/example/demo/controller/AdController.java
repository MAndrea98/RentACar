package com.example.demo.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ad;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.Vehicle;
import com.example.demo.service.AdService;
import com.example.demo.service.RequestService;

@RestController
@RequestMapping(value="ad")
public class AdController {

	@Autowired
	AdService adService;
	
	@Autowired
	RequestService requestService;

	@PostMapping(value="create")
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
		return new ResponseEntity<String>("",HttpStatus.OK);

	}

	@PostMapping(value="/occupy")
	public ResponseEntity<String> occupy(@RequestBody Date dateFrom, @RequestBody Date dateTo, @RequestBody Ad ad){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFrom);
		calendar.setTime(dateTo);

		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(
		//ad.getFree().put(calendar, false);

		Vehicle vehicle = ad.getVehicle();
		List<Request> list = requestService.findAll();
		for(Request r : list) {
			for(Ad a : r.getAds()) {
				if(a.getVehicle().getId() == vehicle.getId() && r.getStatus() == RequestStatus.PENDING) {
					r.setStatus(RequestStatus.CANCELED);
				}
			}
		}

		return new ResponseEntity<String>("",HttpStatus.OK);
	}


}
