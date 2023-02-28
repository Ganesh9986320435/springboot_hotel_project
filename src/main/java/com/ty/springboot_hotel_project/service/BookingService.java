package com.ty.springboot_hotel_project.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.BookingDao;
import com.ty.springboot_hotel_project.dao.CustomerDao;
import com.ty.springboot_hotel_project.dao.RoomDao;
import com.ty.springboot_hotel_project.dto.Booking;
import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.exception.BookingBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.BookingIdNotFoundException;
import com.ty.springboot_hotel_project.repository.BookingsRepository;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired 
	private RoomDao roomDao;
	@Autowired
	private BookingsRepository Repository;
	@Autowired
	private CustomerDao customerDao;
	
	ResponseStructure<Booking> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking,int cid,int rid) {
		Room room=roomDao.getRoomById(rid);
		Customer customer=customerDao.getCustomerById(rid);
		booking.setCustomer(customer);
		booking.setRooms(room);
		Booking booking2 = bookingDao.saveBooking(booking);
		if (booking2 != null) {
			structure.setMessage("booking Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(booking2);
		}
		return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(int bid,Booking booking) {
		
		
		Booking booking2 = bookingDao.getBookingById(bid);
		booking.setCustomer(booking2.getCustomer());
		booking.setRooms(booking2.getRooms());
		if (booking2 != null) {
			booking.setId(bid);
			structure.setMessage("booking Updated Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(bookingDao.updatBooking(booking2));
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new BookingIdNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bid) {
		Booking booking2 = bookingDao.getBookingById(bid);
		if (booking2 != null) {
			structure.setMessage("booking deleted Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(bookingDao.deleteBooking(booking2));
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new BookingIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Booking>> getBookingById(int bid) {
		Booking booking2 = bookingDao.getBookingById(bid);
		if (booking2 != null) {
			structure.setMessage("booking fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(booking2);
			return new ResponseEntity<ResponseStructure<Booking>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new BookingIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> getBookings() {
		ResponseStructure<List<Booking>> responseStructure=new ResponseStructure<>();
		if (bookingDao.getAllBookings()!=null) {
			responseStructure.setMessage("bookings feted Successufully....");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(bookingDao.getAllBookings());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new BookingBodyNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomsByCheckOutAndCheckIn(Date check_in,Date check_out) {
		List<Booking> list=bookingDao.getAllBookings();
		List<Room> list2=new ArrayList<>();
		List<Room> list3=roomDao.getAllRooms();
		for(Booking b:list)
		{
			if(b.getRooms().getAvailability().equals("N"))
			{
//				Booking b1=Repository.getBookingByCheckInByCustomer(check_in, b.getCheck_in_date(), b.getCheck_out_date());
//				Booking b2=Repository.getBookingByCheckOutByCustomer(check_out, b.getCheck_in_date(), b.getCheck_out_date());
//				if(b1==null&&b2==null)
				{
					list2.add(b.getRooms());
				}
				
			}
		}
		for(Room r:list3)
		{
			if(r.getAvailability().equals("Y"))
			{
				list2.add(r);
			}
		}
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Rooms fetched successfully by checkin and checkout date");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(list2);
		return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.OK);
	}

	

	
	

}
