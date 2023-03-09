package com.ty.springboot_hotel_project.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	@NotBlank(message = "customer name should not blank")
	@NotNull(message = "customer name should not be null")
	private String customer_name;
	@NotBlank(message = "customer address should not blank")
	@NotNull(message = "customer address should not be null")
	private String customer_address;
	@NotBlank(message = "customer mail should not blank")
	@NotNull(message = "customer mail should not be null")
	@Pattern(regexp = "[a-zA-Z0-9_/-/.]+[@][a-z]+[/.][a-z]{2,3}")
	private String customer_email;
	@NotBlank(message = "customer pass should not blank")
	@NotNull(message = "customer pass should not be null")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(unique = true)
	private String customer_password;
	@NotBlank(message = "customer phone should not blank")
	@NotNull(message = "customer phone should not be null")
	@Pattern(regexp = "[6-9][0-9]{9}")
	private String customer_phone;
	@NotBlank(message = "customer role should not blank")
	@NotNull(message = "customer role should not be null")
	private String customer_role;
	@NotBlank(message = "customer adhar should not blank")
	@NotNull(message = "customer adhar should not be null")
	@Pattern(regexp = "[1-9][1-9]{11}")
	private String customer_aadharno;
	private int otp;
	
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;	
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_role() {
		return customer_role;
	}
	public void setCustomer_role(String customer_role) {
		this.customer_role = customer_role;
	}
	public String getCustomer_aadharno() {
		return customer_aadharno;
	}
	public void setCustomer_aadharno(String customer_aadharno) {
		this.customer_aadharno = customer_aadharno;
	}
	

}
