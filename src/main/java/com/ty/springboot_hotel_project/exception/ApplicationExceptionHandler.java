package com.ty.springboot_hotel_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.springboot_hotel_project.util.ResponseStructure;

public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	ResponseStructure<String> structure = new ResponseStructure<>();

	@ExceptionHandler(HotelIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hotelIdNotFoundException(HotelIdNotFoundException ex) {
		structure.setMessage("Given Hotel Id Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HotelBodyNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> hotelBodyNotFoundException(HotelIdNotFoundException ex) {
		structure.setMessage("Given Hotel Body Not Found...");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
}
