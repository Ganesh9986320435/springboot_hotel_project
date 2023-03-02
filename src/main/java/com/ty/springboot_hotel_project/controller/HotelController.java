package com.ty.springboot_hotel_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.service.HotelService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HotelController {

	@Autowired
	private HotelService service;
	
	@ApiOperation(value = "Save Hotel", notes = "Api is used to Save the Hotel")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Created"),
			@ApiResponse(code = 404, message = "Hotel Not Saved Give Proper Input") })
	@PostMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> saveHotel(@RequestBody Hotel hotel) {
		return service.saveHotel(hotel);
	}
	
	@ApiOperation(value = "Update Hotel" ,notes = "Api is used to update Hotel with the id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Updated"),
			@ApiResponse(code = 404,message = "Hotel Not Updated Give Proper Input")})
	@PutMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> updateHotel(@RequestParam int hid, @RequestBody Hotel hotel) {
		return service.updateHotel(hid, hotel);
	}

	@ApiOperation(value = "Delete Hotel", notes = "Api is used to Delete the Hotel")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Deleted"),
			@ApiResponse(code = 404, message = "Hotel Not deleted Give Proper Input") })
	@DeleteMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> deleteHotel(@RequestParam int hid) {
		return service.deleteHotel(hid);
	}
	
	@ApiOperation(value = "Get Hotel", notes = "Api is used to Get the Hotel By Particular Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The Hotel"),
			@ApiResponse(code = 404, message = "Hotel Not Found Give Proper Input") })
	@GetMapping("/hotel")
	public ResponseEntity<ResponseStructure<Hotel>> getHotelById(@RequestParam int hid) {
		return service.getHotelById(hid);
	}
	
	@ApiOperation(value = "Get All Hotels", notes = "Api is used to Get the All Hotels ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Found The Hotels"),
			@ApiResponse(code = 404, message = "Hotels Not Found Give Proper Input") })
	@GetMapping("/hotels")
	public ResponseEntity<ResponseStructure<List<Hotel>>> getAllHotel() {
		return service.getAllHotel();
	}
	
	@ApiOperation(value = "Update Review Status", notes = "Api is used to Update the Review Status")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Updated"),
			@ApiResponse(code = 404, message = "Review Not Updated Give Proper Input") })
	@PutMapping("/updatebyreview")
	public ResponseEntity<ResponseStructure<Hotel>> updateByReview(int hid)
	{
		return service.updateHotelReview(hid);
	}
}
