package com.ty.springboot_hotel_project.exception;

public class BookingCheckInDateNotFoundException extends RuntimeException{
	
	private String message = "Booking Check in Date Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public BookingCheckInDateNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BookingCheckInDateNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
