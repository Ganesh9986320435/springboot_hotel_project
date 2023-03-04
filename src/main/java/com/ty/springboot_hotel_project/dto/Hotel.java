package com.ty.springboot_hotel_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;
	@NotBlank(message = "hotel name should not blank")
	@NotNull(message = "hotel name should not be null")
	private String hotel_name;
	@NotBlank(message = "hotel adress should not blank")
	@NotNull(message = "hotel address name should not be null")
	private String hotel_address;
	@NotBlank(message = "hotel gst should not blank")
	@NotNull(message = "hotel gst should not be null")
	private String hotel_gst;
	@NotBlank(message = "hotel owner should not blank")
	@NotNull(message = "hotel owner should not be null")
	private String hotel_owner;
	@NotBlank(message = "hotel manager should not blank")
	@NotNull(message = "hotel manager should not be null")
	private String hotel_manager;
	@Pattern(regexp = "[1-5]")
	private String hotel_review;
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getHotel_gst() {
		return hotel_gst;
	}
	public void setHotel_gst(String hotel_gst) {
		this.hotel_gst = hotel_gst;
	}
	public String getHotel_owner() {
		return hotel_owner;
	}
	public void setHotel_owner(String hotel_owner) {
		this.hotel_owner = hotel_owner;
	}
	public String getHotel_manager() {
		return hotel_manager;
	}
	public void setHotel_manager(String hotel_manager) {
		this.hotel_manager = hotel_manager;
	}
	public String getHotel_review() {
		return hotel_review;
	}
	public void setHotel_review(String hotel_review) {
		this.hotel_review = hotel_review;
	}
}
