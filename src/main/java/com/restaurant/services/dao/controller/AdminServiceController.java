package com.restaurant.services.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.AdminRepository;
import com.restaurant.services.model.Admin;

@RestController
public class AdminServiceController {

	@Autowired
	AdminRepository adminRepository;

	@RequestMapping(value = "/signUpAdmin", method = RequestMethod.POST)
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
		String adminInsertStatus = "Admin SignUp Success! Please Login";
		try {
			adminRepository.registerAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
			adminInsertStatus = "Admin SignUp Failed";
		}
		return new ResponseEntity<String>(adminInsertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateAdminProfile", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
		String adminUpdateStatus = "Admin Update Success!";
		try {
			adminRepository.updateAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
			adminUpdateStatus = "Admin Update Failed";
		}
		return new ResponseEntity<String>(adminUpdateStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAdmin/{adminEmail:.+}", method = RequestMethod.GET, produces = "application/json")
	public Admin getAdmin(@PathVariable("adminEmail") String adminEmail) {
		String sqlStatus = "Sql Success!";
		Admin admin = new Admin();
		try {
			admin = adminRepository.getAdmin(adminEmail);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return admin;
	}

}
