package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.repository.HotelRepository;

@Repository
public class HotelDao {

	@Autowired
	private HotelRepository repository;

	public Hotel saveHotel(Hotel hotel) {
		return repository.save(hotel);
	}

	public Hotel updateHotel(Hotel hotel) {
		return repository.save(hotel);
	}

	public Hotel deleteHotel(Hotel hotel) {
		repository.delete(hotel);
		return hotel;
	}

	public Hotel getHotelById(int hid) {
		if(repository.findById(hid).isPresent())
		{
			return repository.findById(hid).get();

		}
		
		return null;
	}

	public List<Hotel> getAllHotels() {
		return repository.findAll();
	}
}
