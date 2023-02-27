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
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}

	@PutMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestParam int hid, @RequestBody Booking booking) {
		return service.updateBooking(hid, booking);
	}

	@DeleteMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int hid) {
		return service.deleteBooking(hid);
	}

	@GetMapping("/booking")
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(@RequestParam int hid) {
		return service.getBookingById(hid);
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
