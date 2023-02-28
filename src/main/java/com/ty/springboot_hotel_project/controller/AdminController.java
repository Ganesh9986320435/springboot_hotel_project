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

import com.ty.springboot_hotel_project.dto.Admin;
import com.ty.springboot_hotel_project.service.AdminService;
import com.ty.springboot_hotel_project.util.ResponseStructure;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin,@RequestParam int hid) {
		return service.saveAdmin(admin,hid);
	}

	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int aid, @RequestBody Admin admin) {
		return service.updateAdmin(aid, admin);
	}

	@DeleteMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int aid) {
		return service.deleteAdmin(aid);
	}

	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@RequestParam int aid) {
		return service.getAdminById(aid);
	}

	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		return service.getAdmins();
	}
	
	@GetMapping("/adminbyemail")
	public ResponseEntity<ResponseStructure<Admin>> getAdminByEmail(@RequestParam String email) {
		return service.getAdminByEmail(email);
	}	
	
	@GetMapping("/adminlogin")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String email,@RequestParam String password){
		return service.loginAdmin(email,password);
	}
}
