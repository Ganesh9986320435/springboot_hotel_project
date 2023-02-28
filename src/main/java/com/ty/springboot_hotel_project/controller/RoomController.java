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
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room,@RequestParam int hid) {
		return service.saveRoom(room,hid);
	}

	@PutMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@RequestParam int rid, @RequestBody Room room) {
		return service.updateRoom(rid, room);
	}

	@DeleteMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> deleteRoom(@RequestParam int rid) {
		return service.deleteRoom(rid);
	}

	@GetMapping("/room")
	public ResponseEntity<ResponseStructure<Room>> getRoomById(@RequestParam int rid) {
		return service.getRoomById(rid);
	}

	@GetMapping("/rooms")
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		return service.getRooms();
	}
	
	@GetMapping("/roombytype")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByType(@RequestParam String room_type){
		return service.getRoomByType(room_type);
	}
	
	@GetMapping("/roombyno")
	public ResponseEntity<ResponseStructure<Room>> getRoomByNo(@RequestParam String room_no){
		return service.getRoomByNo(room_no);
	}
	
	@GetMapping("/roombyavailability")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByAvailability(@RequestParam String availability) {
		return service.getRoomByAvailability(availability);
	}
	
	
}
