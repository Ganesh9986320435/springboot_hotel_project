package com.ty.springboot_hotel_project.exception;

public class RoomNoNotFoundException extends RuntimeException {
	
	private String message = "Room Number Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomNoNotFoundException(String message) {
		super();
		this.message = message;
	}

	public RoomNoNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
