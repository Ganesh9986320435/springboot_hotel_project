package com.ty.springboot_hotel_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springboot_hotel_project.dto.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

}
