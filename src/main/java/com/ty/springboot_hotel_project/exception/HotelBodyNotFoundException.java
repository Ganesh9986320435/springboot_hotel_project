package com.ty.springboot_hotel_project.exception;

public class HotelBodyNotFoundException extends RuntimeException{
	
	private String message = "Hotel Body Not Found";

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HotelBodyNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
