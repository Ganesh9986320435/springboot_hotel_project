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

import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.service.CustomerService;
import com.ty.springboot_hotel_project.util.ResponseStructure;



@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}

	@PutMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestParam int hid, @RequestBody Customer customer) {
		return service.updateCustomer(hid, customer);
	}

	@DeleteMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@RequestParam int hid) {
		return service.deleteCustomer(hid);
	}

	@GetMapping("/customer")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@RequestParam int hid) {
		return service.getCustomerById(hid);
	}

	@GetMapping("/customers")
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer() {
		return service.getCustomers();
	}
	
	@GetMapping("/customerbyemail")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(@RequestParam String email){
		return service.getCustomerByEmail(email);
	}
}
