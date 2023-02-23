package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.repository.BookingsRepository;

@Repository
public class BookingDao {

	@Autowired
	private BookingsRepository repository;

	public Booking saveBooking(Booking booking) {
		return repository.save(booking);
	}

	public Booking updatBooking(Booking booking) {
		return repository.save(booking);
	}

	public Booking deleteBooking(Booking booking) {
		repository.delete(booking);
		return booking;
	}

	public Booking getBookingById(int bid) {
		return repository.findById(bid).get();
	}

	public List<Booking> getAllBookings() {
		return repository.findAll();
	}

	public Booking getBookingByCheckIn(String check_in_date) {
		return repository.getBookingByCheckIn(check_in_date);
	}

	public Booking getBookingByCheckOut(String check_out_date) {
		return repository.getBookingByCheckOut(check_out_date);
	}

}
