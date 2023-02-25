package com.ty.springboot_hotel_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springboot_hotel_project.dao.AdminDao;
import com.ty.springboot_hotel_project.dto.Admin;
import com.ty.springboot_hotel_project.dto.Hotel;
import com.ty.springboot_hotel_project.exception.AdminBodyNotFoundException;
import com.ty.springboot_hotel_project.exception.AdminEmailNotFoundException;
import com.ty.springboot_hotel_project.exception.AdminIdNotFoundException;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	ResponseStructure<Admin> structure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		Admin admin2 = adminDao.saveAdmin(admin);
		if (admin2 != null) {
			structure.setMessage("admin Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(admin2);
		}
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int aid,Admin admin) {
		Admin admin2 = adminDao.getAdminById(aid);
		if (admin2 != null) {
			admin.setAdmin_id(aid);
			structure.setMessage("admin Saved Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(adminDao.updatAdmin(admin2));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new AdminIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int aid) {
		Admin admin2 = adminDao.getAdminById(aid);
		if (admin2 != null) {
			structure.setMessage("admin deleted Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(adminDao.deleteAdmin(admin2));
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new AdminIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int aid) {
		Admin admin2 = adminDao.getAdminById(aid);
		if (admin2 != null) {
			structure.setMessage("admin fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(admin2);
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new AdminIdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(String email) {
		Admin admin2 = adminDao.getAdminByEmail(email);
		if (admin2 != null) {
			structure.setMessage("admin fetched Successufully....");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(admin2);
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
		}
		else {
			throw new AdminEmailNotFoundException();

		}
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getAdmins() {
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<>();
		if (adminDao.getAllAdmins()!=null) {
			responseStructure.setMessage("admins feted Successufully....");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(adminDao.getAllAdmins());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new AdminBodyNotFoundException();
		}
	}
	
	
	




}
