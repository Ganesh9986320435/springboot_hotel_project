package com.ty.springboot_hotel_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.HotelDao;
import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDao;

	ResponseStructure<Hotel> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(Hotel hotel) {
		Hotel hotel2 = hotelDao.saveHotel(hotel);
		if (hotel2 != null) {
			structure.setMessage("Hotel Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(hotel2);
		}
		return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.CREATED);

	}
}
