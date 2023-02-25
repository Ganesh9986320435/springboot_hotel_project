package com.ty.springboot_hotel_project.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.dto.Room;
import com.ty.springboot_hotel_project.service.RoomService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@RestController
public class RoomController {

	
	@Autowired
	private RoomService service;

	@PostMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		return service.saveRoom(room);
	}

	@PutMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@RequestParam int hid, @RequestBody Room room) {
		return service.updateRoom(hid, room);
	}

	@DeleteMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(@RequestParam int hid) {
		return service.deleteRoom(hid);
	}

	@GetMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> getRoomById(@RequestParam int hid) {
		return service.getRoomById(hid);
	}

	@GetMapping("/rooms")
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		return service.getRooms();
	}
	
	@GetMapping("/roombytype")
	public ResponseEntity<ResponseStructure<Room>> getRoomByType(String room_type){
		return service.getRoomByType(room_type);
	}
	
	@GetMapping("/roombyno")
	public ResponseEntity<ResponseStructure<Room>> getRoomByNo(String room_no){
		return service.getRoomByNo(room_no);
	}
	
	@GetMapping("/roombyavailability")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByAvailability(String availability) {
		return service.getRoomByAvailability(availability);
	}
	
	
}
