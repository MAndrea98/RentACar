package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
import com.example.demo.service.PriceListService;
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
	
	@Autowired
	private PriceListService priceListService;

	@PostMapping(value="/create/{modelName}")
	public ResponseEntity<Ad> createAd(@RequestBody Ad ad, @PathVariable("modelName") String modelName) {
		if(ad.equals(null) || modelName.equals(null)) {
			return new ResponseEntity<Ad>(HttpStatus.NO_CONTENT);
		}
		
		Model m = modelService.findByName(modelName);
		
		Vehicle v = vehicleService.findByModel(m);
		System.err.println(v.getId());
		ad.setVehicle(v);
		adService.save(ad);
		return new ResponseEntity<Ad>(ad,HttpStatus.OK);

	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<Ad>> findAll() {
		List<Ad> ret = adService.findAll();
		return new ResponseEntity<List<Ad>>(ret,HttpStatus.OK);
	}
	
	@PostMapping(value="/discount/{adId}/{discount}/{dateFrom}/{dateTo}")
	public ResponseEntity<Discount> createDiscount(@PathVariable("adId") Long adId,
												   @PathVariable("discount") double value,
												   @PathVariable("dateFrom") Date dateFrom,
												   @PathVariable("dateTo") Date dateTo
												   ) {
		Discount d = new Discount();
		
		LocalDate date1 = convertToLocalDateViaInstant(dateFrom);
		LocalDate date2 = convertToLocalDateViaInstant(dateTo);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-dd-MM");
		formatter.format(date1);
		formatter.format(date2);
		
		Calendar c1= Calendar.getInstance();
		c1.set(date1.getYear(), date1.getMonthValue(), date1.getDayOfMonth());
		
		Calendar c2= Calendar.getInstance();
		c2.set(date2.getYear(), date2.getMonthValue(), date2.getDayOfMonth());
		
		d.setValue(value);
		d.setValidFrom(c1);
		d.setValidTru(c2);
		
		Vehicle v = adService.findById(adId).getVehicle();
		List<Vehicle> vl = new ArrayList<Vehicle>();
		vl.add(v);
		PriceList p = new PriceList();
		p.setDateFrom(c1);
		p.setDateTo(c2);
		p.setVehicle(vl);
		p.setPricePerMile(100);
		p.setCdwPrice(5);
		v.getPriceList().add(p);
		priceListService.save(p);
		d.setPriceList(p);
		
		discountService.save(d);
		return new ResponseEntity<Discount>(d, HttpStatus.OK);
		
	}
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

	@PutMapping(value="/occupy/{dateFrom}/{dateTo}/{adId}")
	public ResponseEntity<String> occupy(@PathVariable("dateFrom") Date dateFrom, @PathVariable("dateTo") Date dateTo, @PathVariable("adId") Long id){
		
		if(dateFrom == null || dateTo == null || id == null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		LocalDate date1 = convertToLocalDateViaInstant(dateFrom);
		LocalDate date2 = convertToLocalDateViaInstant(dateTo);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-dd-MM");
		formatter.format(date1);
		formatter.format(date2);
		System.out.println(date1);
		System.out.println(date2);
		
		Calendar c1= Calendar.getInstance();
		c1.set(date1.getYear(), date1.getMonthValue(), date1.getDayOfMonth());
		
		Calendar c2= Calendar.getInstance();
		c2.set(date2.getYear(), date2.getMonthValue(), date2.getDayOfMonth());
		
		Ad ad = adService.findById(id);
		ad.setDateFrom(c1);
		ad.setDateTo(c2);

		Vehicle vehicle = ad.getVehicle();
		List<Request> list = requestService.findAll();
		for(Request r : list) {
			for(Ad a : r.getAds()) {
				if(a.getVehicle().getId() == vehicle.getId() && r.getStatus() == RequestStatus.PENDING) {
					r.setStatus(RequestStatus.CANCELED);
				}
			}
		}
		
		adService.save(ad);

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
