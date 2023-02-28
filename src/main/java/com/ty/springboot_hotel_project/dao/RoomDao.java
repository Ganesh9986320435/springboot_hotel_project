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
		if(repository.findById(rid).isPresent())
		{
			return repository.findById(rid).get();

		}
		
		return null;
	}

	public List<Room> getAllRooms() {
		return repository.findAll();
	}

	public Room getRoomByType(String room_type) {
		if(repository.getRoomByType(room_type)!=null)
		{
			return repository.getRoomByType(room_type);

		}
		
		return null;	}

	public Room getRoomByNo(String room_no) {
		if(repository.getRoomByNo(room_no)!=null)
		{
			return repository.getRoomByNo(room_no);

		}
		
		return null;	}

	public List<Room> getRoomByAvailability(String availability) {
		return repository.getRoomByAvailability(availability);
}
}
