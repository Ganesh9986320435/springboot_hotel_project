package com.ty.springboot_hotel_project.exception;

public class BookingCheckOutDateNotFoundException extends RuntimeException{
	
	private String message = "Booking Check Out Date Not Availbale";

	@Override
	public String getMessage() {
		return message;
	}

	public BookingCheckOutDateNotFoundException(String message) {
		super();
		this.message = message;
	}

	public BookingCheckOutDateNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
