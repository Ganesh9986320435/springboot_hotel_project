package com.ty.springboot_hotel_project.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
	@NotBlank(message = "admin name should not blank")
	@NotNull(message = "admin name should not be null")
	private String admin_name;
	@NotBlank(message = "admin email should not blank")
	@NotNull(message = "admin mail should not be null")
	@Pattern(regexp = "[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}")
	private String admin_email;
	@NotBlank(message = "admin pass should not blank")
	@NotNull(message = "admin pass should not be null")
	private String admin_password;
	@NotBlank(message = "admin role should not blank")
	@NotNull(message = "admin role should not be null")
	private String admin_role;
	@OneToOne
	private Hotel hotel;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_role() {
		return admin_role;
	}

	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
}
