package com.ty.springboot_hotel_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springboot_hotel_project.dto.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
}
