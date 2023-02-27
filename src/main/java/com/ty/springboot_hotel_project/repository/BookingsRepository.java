package com.ty.springboot_hotel_project.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hotel_project.dto.Booking;

public interface BookingsRepository extends JpaRepository<Booking, Integer>{
	@Query("select b from Booking b where b.check_in_date=?1")
	public Booking getBookingByCheckIn(String check_in_date);
	
	@Query("select b from Booking b where b.check_out_date=?1")
	public Booking getBookingByCheckOut(String check_out_date);
	
//	@Query("select b from Booking b where b.chek_in_date=?1 between b.check_in_date=?2 and b.check_out_date=?3")
//	public Booking getBookingByCheckInByCustomer(Date chek_in_date,Date check_in_date,Date check_out_date);
//	
//	@Query("select b from Booking b where b.chek_out_date=?1 between b.check_in_date=?2 and b.check_out_date=?3")
//	public Booking getBookingByCheckOutByCustomer(Date chek_out_date,Date check_in_date,Date check_out_date);
	
}
