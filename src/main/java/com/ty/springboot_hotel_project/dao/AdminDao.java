package com.ty.springboot_hotel_project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springboot_hotel_project.dto.Admin;
import com.ty.springboot_hotel_project.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository repository;

	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}

	public Admin updatAdmin(Admin admin) {
		return repository.save(admin);
	}

	public Admin deleteAdmin(Admin admin) {
		repository.delete(admin);
		return admin;
	}

	public Admin getAdminById(int aid) {
		return repository.findById(aid).get();
	}

	public List<Admin> getAllAdmins() {
		return repository.findAll();
	}
	
	public Admin getAdminByEmail(String admin_email) {
		return repository.getAdminByEmial(admin_email);
	}
}
