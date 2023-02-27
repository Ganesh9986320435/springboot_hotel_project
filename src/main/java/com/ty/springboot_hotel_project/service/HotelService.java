package com.ty.springboot_hotel_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.HotelDao;
import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.exception.HotelBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.HotelIdNotFoundException;
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

	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(int hid, Hotel hotel) {
		Hotel hotel2 = hotelDao.getHotelById(hid);
		if (hotel2 != null) {
			hotel.setHotel_id(hid);
			structure.setMessage("Hotel Updated Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hotelDao.updateHotel(hotel));
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.OK);
		} else {
			throw new HotelIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(int hid) {
		Hotel hotel2 = hotelDao.getHotelById(hid);
		if (hotel2 != null) {
			structure.setMessage("Hotel Deleted Successufully....");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(hotelDao.deleteHotel(hotel2));
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.OK);
		} else {
			throw new HotelIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Hotel>> getHotelById(int hid) {
		Hotel hotel2 = hotelDao.getHotelById(hid);
		if (hotel2 != null) {
			structure.setMessage("Hotel Found Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hotel2);
			return new ResponseEntity<ResponseStructure<Hotel>>(structure, HttpStatus.FOUND);
		} else {
			throw new HotelIdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Hotel>>> getAllHotel() {
		ResponseStructure<List<Hotel>> structure = new ResponseStructure<>();
		List<Hotel> hotels = hotelDao.getAllHotels();
		if (hotels != null) {
			structure.setMessage("Hotels Found Successufully....");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hotels);
			return new ResponseEntity<ResponseStructure<List<Hotel>>>(structure, HttpStatus.FOUND);
		} else {
			throw new HotelBodyNotFoundException();
		}
	}

}
