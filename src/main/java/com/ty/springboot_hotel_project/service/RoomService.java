package com.ty.springboot_hotel_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.RoomDao;
import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.exception.CustomerIdNotFoundException;
import com.ty.springboot_hotel_project.exception.RoomAvailabilityNotFoundException;
import com.ty.springboot_hotel_project.exception.RoomBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.RoomIdNotFoundException;
import com.ty.springboot_hotel_project.exception.RoomNoNotFoundException;
import com.ty.springboot_hotel_project.exception.RoomTypeNotFoundException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	ResponseStructure<Room> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {
		Room room2 = roomDao.saveRoom(room);
		if (room2 != null) {
			structure.setMessage("room Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(room2);
		}
		return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Room>> updateRoom(int aid,Room room) {
		Room room2 = roomDao.getRoomById(aid);
		if (room2 != null) {
			room.setId(aid);
			structure.setMessage("room Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(roomDao.updatRoom(room2));
			return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new RoomIdNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(int aid) {
		Room room2 = roomDao.getRoomById(aid);
		if (room2 != null) {
			structure.setMessage("room deleted Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(roomDao.deleteRoom(room2));
			return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new RoomIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> getRoomById(int aid) {
		Room room2 = roomDao.getRoomById(aid);
		if (room2 != null) {
			structure.setMessage("room fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(room2);
			return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new RoomIdNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> getRoomByType(String room_type) {
		Room room2 = roomDao.getRoomByType(room_type);
		if (room2 != null) {
			structure.setMessage("room fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(room2);
			return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new RoomTypeNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<Room>> getRoomByNo(String room_no) {
		Room room2 = roomDao.getRoomByNo(room_no);
		if (room2 != null) {
			structure.setMessage("room fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(room2);
			return new ResponseEntity<ResponseStructure<Room>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new RoomNoNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByAvailability(String availability) {
		List<Room> room2 = roomDao.getRoomByAvailability(availability);
		if (room2 != null) {
			ResponseStructure<List<Room>> structure = new ResponseStructure<>();

			structure.setMessage("room fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(room2);
			return new ResponseEntity<ResponseStructure<List<Room>>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new RoomAvailabilityNotFoundException();
		}
	}
	public ResponseEntity<ResponseStructure<List<Room>>> getRooms() {
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<>();
		if (roomDao.getAllRooms()!=null) {
			responseStructure.setMessage("rooms feted Successufully....");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(roomDao.getAllRooms());
			return new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new RoomBodyNotFoundException();

		}
	}

}
