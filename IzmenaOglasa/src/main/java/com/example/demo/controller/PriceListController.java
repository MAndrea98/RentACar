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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PriceListDTO;
import com.example.demo.model.PriceList;
import com.example.demo.service.PriceListService;

@RestController
@RequestMapping(value = "/priceList")
@CrossOrigin("http://localhost:4200")
public class PriceListController {
	
	// TODO neophodno je izmeniti svaki priceList u programu, potrebno je dodati u skriptu, 
	// i njega prosiriti na ceo program
	// treba odraditi frontend za dodavanje i izmenu
	
	@Autowired
	private PriceListService priceListService;

	@PostMapping
	public ResponseEntity<PriceListDTO> addPriceList(@RequestBody PriceListDTO priceListDTO) {
		PriceList priceList = new PriceList();
		priceList.setDateFrom(priceListDTO.getDateFrom());
		priceList.setDateTo(priceList.getDateTo());
		priceList.setPrices(priceList.getPrices());
		priceList.setCdwPrice(priceList.getCdwPrice());
		priceList.setPricePerMile(priceList.getPricePerMile());
		priceList.setVehicle(priceListDTO.getVehicle());
		PriceList p = priceListService.save(priceList);
		return new ResponseEntity<PriceListDTO>(new PriceListDTO(p), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<PriceListDTO>> getAll() {
		List<PriceList> priceLists = priceListService.findAll();
		List<PriceListDTO> priceListDTOs = new ArrayList<PriceListDTO>();
		for (PriceList p : priceLists)
			priceListDTOs.add(new PriceListDTO(p));
		return new ResponseEntity<List<PriceListDTO>>(priceListDTOs, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<PriceListDTO> editPriceList(@RequestBody PriceListDTO priceListDTO) {
		PriceList priceList = priceListService.findById(priceListDTO.getId());
		priceList.setDateFrom(priceListDTO.getDateFrom());
		priceList.setDateTo(priceList.getDateTo());
		priceList.setPrices(priceList.getPrices());
		priceList.setCdwPrice(priceList.getCdwPrice());
		priceList.setPricePerMile(priceList.getPricePerMile());
		priceList.setVehicle(priceListDTO.getVehicle());
		PriceList p = priceListService.save(priceList);
		return new ResponseEntity<PriceListDTO>(new PriceListDTO(p), HttpStatus.OK); 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletePriceList(@PathVariable("id") Long id) {
		priceListService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/removePrice/{id}/{key}")
	public ResponseEntity<PriceListDTO> removePriceItem(@PathVariable("id") Long id, @PathVariable("key") String key) {
		PriceList priceList = priceListService.findById(id);
		priceList.getPrices().remove(key);
		PriceList p = priceListService.save(priceList);
		return new ResponseEntity<PriceListDTO>(new PriceListDTO(p), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/removeVehicle/{id}/{id_vehicle}")
	public ResponseEntity<PriceListDTO> removeVehicle(@PathVariable("id") Long idP, @PathVariable("id_vehicle") Long idV) {
		System.out.println("###" + idP + "  " + idV);
		PriceList priceList = priceListService.findById(idP);
		for (int i = 0; i < priceList.getVehicle().size(); i++) {
			if (priceList.getVehicle().get(i).getId().equals(idV)) {
				priceList.getVehicle().remove(i);
			}
		}
		
		PriceList p = priceListService.save(priceList);
		return new ResponseEntity<PriceListDTO>(new PriceListDTO(p), HttpStatus.OK);
	}
}
