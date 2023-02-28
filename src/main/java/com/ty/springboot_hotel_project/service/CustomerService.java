package com.ty.springboot_hotel_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.CustomerDao;
import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.exception.BookingIdNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerEmailNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerIdNotFoundException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	ResponseStructure<Customer> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		Customer customer2 = customerDao.saveCustomer(customer);
		if (customer2 != null) {
			structure.setMessage("customer Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customer2);
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int cid,Customer customer) {
		Customer customer2 = customerDao.getCustomerById(cid);
		if (customer2 != null) {
			customer.setCustomer_id(cid);
			structure.setMessage("customer updated Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customerDao.updateCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new CustomerIdNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int cid) {
		Customer customer2 = customerDao.getCustomerById(cid);
		if (customer2 != null) {
			structure.setMessage("customer deleted Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customerDao.deleteCustomer(customer2));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new CustomerIdNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int cid) {
		Customer customer2 = customerDao.getCustomerById(cid);
		if (customer2 != null) {
			structure.setMessage("customer fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customer2);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new CustomerIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerByEmail(String email) {
		Customer customer2 = customerDao.getCustomerByEmail(email);
		if (customer2 != null) {
			structure.setMessage("customer fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customer2);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new CustomerEmailNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getCustomers() {
		ResponseStructure<List<Customer>> responseStructure=new ResponseStructure<>();
		if (customerDao.getAllCustomers()!=null) {
			responseStructure.setMessage("customers feted Successufully....");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.getAllCustomers());
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new CustomerBodyNotFoundException();
		}
	}

}
