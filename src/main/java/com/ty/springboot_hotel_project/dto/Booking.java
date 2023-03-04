package com.ty.springboot_hotel_project.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "check in should not blank")
	@NotNull(message = "checkin should not be null")
	@Pattern(regexp = "[0-9]{4}[/-][0-9]{2}[/-][0-9]{2}")
	private String check_in_date;
	@NotBlank(message = "check out should not blank")
	@NotNull(message = "checkout should not be null")
	@Pattern(regexp = "[0-9]{4}[/-][0-9]{2}[/-][0-9]{2}")
	private String check_out_date;	
	@NotBlank(message = "checkin time should not blank")
	@NotNull(message = "checkin time should not be null")
	@Pattern(regexp = "[0-9]{2}[:][0-9]{2}")
	private String check_in_time;
	@NotBlank(message = "checkout time should not blank")
	@NotNull(message = "checkout time should not be null")
	@Pattern(regexp = "[0-9]{2}[:][0-9]{2}")
	private String check_out_time;
	@NotBlank(message = "no of people should not blank")
	@NotNull(message = "no of people should not be null")
	private String no_of_people;
	@Pattern(regexp = "[1-5]")
	private String review;
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Customer customer;

	@OneToOne
	private Room rooms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}

	public String getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}

	public String getNo_of_people() {
		return no_of_people;
	}

	public void setNo_of_people(String no_of_people) {
		this.no_of_people = no_of_people;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRooms() {
		return rooms;
	}

	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}

	public String getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(String check_in_date) {
		this.check_in_date = check_in_date;
	}

	public String getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(String check_out_date) {
		this.check_out_date = check_out_date;
	}
	
	
	
	

}
