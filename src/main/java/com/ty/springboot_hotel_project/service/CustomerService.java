package com.ty.springboot_hotel_project.service;

import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.CustomerDao;
import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.exception.CustomerBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerEmailNotFoundException;
import com.ty.springboot_hotel_project.exception.CustomerIdNotFoundException;
import com.ty.springboot_hotel_project.util.Aes;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private Aes aes;

	@Autowired
	JavaMailSender mailSender;

	ResponseStructure<Customer> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		customer.setCustomer_password(aes.encrypt(customer.getCustomer_password()));
		Customer customer2 = customerDao.saveCustomer(customer);
		if (customer2 != null) {
			structure.setMessage("customer Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customer2);
		}
		return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int cid, Customer customer) {
		Customer customer2 = customerDao.getCustomerById(cid);
		if (customer2 != null) {
			customer.setCustomer_id(cid);
			structure.setMessage("customer updated Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customerDao.updateCustomer(customer));
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
		} else {
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
		} else {
			throw new CustomerIdNotFoundException();

		}
	}

	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int cid) {
		Customer customer2 = customerDao.getCustomerById(cid);
		if (customer2 != null) {
			customer2.setCustomer_password(aes.decrypt(customer2.getCustomer_password()));
			structure.setMessage("customer fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(customer2);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.CREATED);
		} else {
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
		} else {
			throw new CustomerEmailNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<List<Customer>>> getCustomers() {
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
		if (customerDao.getAllCustomers() != null) {
			responseStructure.setMessage("customers feted Successufully....");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(customerDao.getAllCustomers());
			return new ResponseEntity<ResponseStructure<List<Customer>>>(responseStructure, HttpStatus.CREATED);
		} else {
			throw new CustomerBodyNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> loginCustomer(String email, String password) {
		Customer customer = customerDao.getCustomerByEmail(email);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		if (customer.getCustomer_password().equals(password) && customer.getCustomer_role().equals("customer")) {
			responseStructure.setMessage("Customers Logged In Successufully....");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("enter valid email and password....");
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.BAD_REQUEST);
		}
	}

	public void generateOtp(String email) {

		int otp = new Random().nextInt(900000) + 100000;

		Customer customer = customerDao.getCustomerByEmail(email);
		if (customer == null) {
			throw new RuntimeException("User Not Found");
		}

		String subject = "Password Reset OTP";
		String text = "Your OTP for resetting Password is :" + otp;
		customer.setOtp(otp);
		customerDao.saveCustomer(customer);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(customer.getCustomer_email());
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}

	public ResponseEntity<ResponseStructure<Customer>> verify(int otp, String email) {
		Customer customer = customerDao.getCustomerByEmail(email);
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		if (customer.getOtp() == otp) {
			structure.setMessage("saved");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure, HttpStatus.OK);
		}
		return null;
	}
}
