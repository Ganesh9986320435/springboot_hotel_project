package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.repository.RoomRepository;

@Repository
public class RoomDao {

	@Autowired
	private RoomRepository repository;

	public Room saveRoom(Room room) {
		return repository.save(room);
	}

	public Room updatRoom(Room room) {
		return repository.save(room);
	}

	public Room deleteRoom(Room room) {
		repository.delete(room);
		return room;
	}

	public Room getRoomById(int rid) {
		return repository.findById(rid).get();
	}

	public List<Room> getAllRooms() {
		return repository.findAll();
	}

	public Room getRoomByType(String room_type) {
		return repository.getRoomByType(room_type);
	}

	public Room getRoomByNo(String room_no) {
		return repository.getRoomByNo(room_no);
	}

	public List<Room> getRoomByAvailability(String availability) {
		return repository.getRoomByAvailability(availability);
}
}
