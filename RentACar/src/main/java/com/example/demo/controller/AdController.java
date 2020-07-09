package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdDTO;
import com.example.demo.model.Ad;
import com.example.demo.model.Discount;
import com.example.demo.model.Model;
import com.example.demo.model.PriceList;
import com.example.demo.model.Renter;
import com.example.demo.model.Request;
import com.example.demo.model.RequestStatus;
import com.example.demo.model.Review;
import com.example.demo.model.Search;
import com.example.demo.model.Vehicle;
import com.example.demo.service.AdService;
import com.example.demo.service.DiscountService;
import com.example.demo.service.ModelService;
import com.example.demo.service.RequestService;
import com.example.demo.service.ReviewService;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping(value="/ad")
@CrossOrigin("http://localhost:4200")
public class AdController {

	@Autowired
	private AdService adService;

	@Autowired
	private RequestService requestService;

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ModelService modelService;

	@PostMapping(value="/create/{modelName}")
	public ResponseEntity<String> createAd(@RequestBody Ad ad, @PathVariable("modelName") String modelName) {
		if(ad.equals(null) || modelName.equals(null)) {
			return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
		}
		
		Model m = modelService.findByName(modelName);
		
		Vehicle v = vehicleService.findByModel(m);
		System.err.println(v.getId());
		ad.setVehicle(v);
		adService.save(ad);
		return new ResponseEntity<String>("OK",HttpStatus.OK);

	}
	
	@PostMapping(value="/discount")
	public ResponseEntity<Discount> createDiscount(@RequestParam("value") String value,
												   @RequestParam("validFrom") String validFrom,
												   @RequestParam("validTru") String validTru,
												   @RequestParam("vehicleId") String vehicleId
												   ) {
		
		if(value.equals(null) || validFrom.equals(null) || validTru.equals(null) || vehicleId.equals(null)) {
			return new ResponseEntity<Discount>(HttpStatus.NO_CONTENT);
		}
		
		Double valueD;
		Discount d = new Discount();
		Date dateValidFrom;
		Date dateValidTru;
		Long vehicleIdL;
		try {
			valueD = Double.parseDouble(value);
			dateValidFrom = new SimpleDateFormat("dd/MM/yyyy").parse(validFrom);
			dateValidTru = new SimpleDateFormat("dd/MM/yyyy").parse(validTru);
			vehicleIdL = Long.parseLong(vehicleId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Discount>(HttpStatus.NO_CONTENT);
		}		
		
		Calendar calValidFrom = Calendar.getInstance();
		calValidFrom.setTime(dateValidFrom);
		
		Calendar calValidTru = Calendar.getInstance();
		calValidFrom.setTime(dateValidTru);
		
		d.setValue(valueD);
		d.setValidFrom(calValidFrom);
		d.setValidTru(calValidTru);
		
		Vehicle v = vehicleService.findById(vehicleIdL);
		
		PriceList p = new PriceList();
		p.setDateFrom(calValidFrom);
		p.setDateTo(calValidTru);
		p.setVehicle(v);
		//p.setPricePerMile(pricePerMile);
		//p.setCdwPrice(cdwPrice);
		d.setPriceList(p);
		
		discountService.save(d);
		return new ResponseEntity<Discount>(d, HttpStatus.OK);
		
	}

	@PostMapping(value="/occupy/{dateFrom}/{dateTo}")
	public ResponseEntity<String> occupy(@PathParam("dateFrom") Date dateFrom, @PathParam("dateTo") Date dateTo, @RequestBody Ad ad){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFrom);
		calendar.setTime(dateTo);

		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(

		Vehicle vehicle = ad.getVehicle();
		List<Request> list = requestService.findAll();
		for(Request r : list) {
			for(Vehicle v : r.getVehicles()) {
				if(v.getId() == vehicle.getId() && r.getStatus() == RequestStatus.PENDING) {
					r.setStatus(RequestStatus.CANCELED);
				}
			}
		}

		return new ResponseEntity<String>("",HttpStatus.OK);
	}

	@PostMapping(value="/search")
	public List<Ad> search(@RequestBody Search search){

		List<Ad> listOfAds = adService.findAll();
		List<Ad> listOfFoundAds = new ArrayList<Ad>();
		for(Ad a : listOfAds) {
			if(a.getPlace() == search.getPlace() && search.getDateFrom().before(a.getDateFrom()) && a.getDateTo().before(search.getDateTo())) {
				listOfFoundAds.add(a);
			}
		}
		return listOfFoundAds;

	}

	@PostMapping(value="/statsMileage")
	public List<Ad> statsMileage(@RequestBody Renter enteredAgent){

		List<Ad> listOfAds = adService.findAll();
		List<Ad> listOfEnteredAgentAds = new ArrayList<Ad>();
		for(Ad a : listOfAds) {
			if(a.getVehicle().getOwner() == enteredAgent) {
				listOfEnteredAgentAds.add(a);
			}
		}

		//listOfEnteredAgentAds.sort(Comparator.comparingInt(Ad::getMileage).reversed());
		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(
		
		
		return listOfEnteredAgentAds;
	}

	@PostMapping(value="/statsStars")
	public List<Ad> statsStars(@RequestBody Renter enteredAgent, @RequestBody Review review){

		List<Review> listOfReviews = reviewService.findAll();  //nadjem sve reviewe
		List<Review> listOfAgentsReviews = new ArrayList<Review>(); //napravim listu reviewa za jednog agenta

		for(Review r : listOfReviews) { //prolazim kroz sve reviewe
			if(r.getAd().getVehicle().getOwner() == enteredAgent) { //ako je polje renter iz klase review kao unesen renter
				listOfAgentsReviews.add(r); //popunjavam listu reviewima od tog rentera
			}
		}

		listOfAgentsReviews.sort(Comparator.comparingInt(Review::getStars).reversed()); //sortiram popunjenu listu

		List<Ad> listOfAgentsAds = listOfAgentsReviews.stream().map(Review::getAd).collect(Collectors.toList());
		//uzimanje samo polja Ad iz prethodne liste i stavljanje ga u novu listu, listu Adova
		List<Ad> listOfAds = adService.findAll();
		listOfAgentsAds.retainAll(listOfAds); //uzimanje objekta Ad u poredjenju dve liste gde koji su isti
		//i sortirani su na nacin prve liste listOfAgentsAds

		return listOfAgentsAds;

	}

	@PostMapping(value="/statsSumReviews")
	public List<Ad> statsSumReviews(@RequestBody Renter enteredAgent, @RequestBody Ad ad){

		List<Ad> listOfAds = adService.findAll();
		List<Ad> listOfEnteredAgentAds = new ArrayList<Ad>();
		for(Ad a : listOfAds) {
			if(a.getVehicle().getOwner() == enteredAgent) {
				listOfEnteredAgentAds.add(a);
			}
		}
		listOfEnteredAgentAds.sort(Comparator.comparingInt(Ad::getNumberOfReviews).reversed());
		return listOfEnteredAgentAds;

	}

	@PostMapping(value="/createAdAgent")
	public ResponseEntity<String> createAdAgent(@RequestBody Ad ad) {
		if(ad.equals(null)) {
			return new ResponseEntity<String>("",HttpStatus.NO_CONTENT);
		}

		Ad newAd = new Ad();
		newAd.setDate(ad.getDate());
		//newAd.setUser(ad.getUser());
		newAd.setValidFrom(ad.getValidFrom());
		newAd.setValidTru(ad.getValidTru());
		newAd.setVehicle(ad.getVehicle());

		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(
		
		
		adService.save(newAd);
		
		
		return new ResponseEntity<String>("",HttpStatus.OK);
	}

	@PostMapping(value="/changeMileage")
	public ResponseEntity<String> changeMileage(@RequestBody AdDTO adDto, @RequestBody int mileage){
		/*Ad ad = adService.findById(adDto.getId());
		ad.setMileage(mileage);
		adService.save(ad);*/
		
		// TODO obrisan je mileage i free nemestiti za vehicle - sorry :(

		return new ResponseEntity<String>("",HttpStatus.OK);
	}
}
