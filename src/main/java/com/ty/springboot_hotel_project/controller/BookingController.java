package com.ty.springboot_hotel_project.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.service.BookingService;
import com.ty.springboot_hotel_project.util.ResponseStructure;


@RestController
public class BookingController {
	
	@Autowired
	private BookingService service;

	@PostMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking,@RequestParam int cid, @RequestParam int rid) {
		return service.saveBooking(booking,cid,rid);
	}

	@PutMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestParam int bid, @RequestBody Booking booking  ) {
		return service.updateBooking(bid, booking);
	}

	@DeleteMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bid) {
		return service.deleteBooking(bid);
	}

	@GetMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@RequestParam int bid) {
		return service.getBookingById(bid);
	}

	@GetMapping("/bookings")
	public ResponseEntity<ResponseStructure<List<Booking>>> getAllBooking() {
		return service.getBookings();
	}
	
	@GetMapping("/bookingsbycheck")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomsByCheckOutAndCheckIn(@RequestParam Date check_in,@RequestParam Date check_out){
		return service.getRoomsByCheckOutAndCheckIn(check_in, check_out);
	}
	
	
	
	
}
