package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Customer;
import com.ty.springboot_hotel_project.repository.CustomerRepository;
import com.ty.springboot_hotel_project.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository repository;

	public Customer saveCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

	public Customer deleteCustomer(Customer customer) {
		repository.delete(customer);
		return customer;
	}

	public Customer getCustomerById(int hid) {
		return repository.findById(hid).get();
	}
	
	public Customer getCustomerByEmail(String email)
	{
		return repository.getCustomerByEmail(email);
	}

	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}

}
