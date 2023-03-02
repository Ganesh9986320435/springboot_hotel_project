package com.ty.springboot_hotel_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.service.HotelService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@RestController
public class HotelController {

	@Autowired
	private HotelService service;

	@PostMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(@RequestBody Hotel hotel) {
		return service.saveHotel(hotel);
	}

	@PutMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(@RequestParam int hid, @RequestBody Hotel hotel) {
		return service.updateHotel(hid, hotel);
	}

	@DeleteMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(@RequestParam int hid) {
		return service.deleteHotel(hid);
	}

	@GetMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> getHotelById(@RequestParam int hid) {
		return service.getHotelById(hid);
	}

	@GetMapping("/hotels")
	public ResponseEntity<ResponseStructure<List<Hotel>>> getAllHotel() {
		return service.getAllHotel();
	}

	@PutMapping("/updatebyreview")
	public ResponseEntity<ResponseStructure<Hotel>> updateByReview(int hid)
	{
		return service.updateHotelReview(hid);
	}
}
