package com.restaurant.services.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.RestAdminRepository;
import com.restaurant.services.model.RestAdmin;

@RestController
public class RestAdminServiceController {

	@Autowired
	RestAdminRepository restAdminRepository;
	
	@RequestMapping(value = "/addToRestAdmin/{restID}", method = RequestMethod.POST)
	public ResponseEntity<String> addToRestAdmin(@RequestBody RestAdmin restAdmin, @PathVariable("restID") String restId) {
		
		String restAdminInsertStatus = "RestAdmin Insert Success!";
		try {
			restAdminRepository.addToRestAdmin(restAdmin,restId);
		} catch (Exception e) {
			e.printStackTrace();
			restAdminInsertStatus = "RestAdmin Insert Failed";
		}
	return new ResponseEntity<String>(restAdminInsertStatus, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/updateRestAdmin", method = RequestMethod.PUT)
	public ResponseEntity<String> updateRestAdmin(@RequestBody RestAdmin restAdmin) {
		String restAdminUpdateStatus = "RestAdmin Update Success!";
		try {
			restAdminRepository.updateRestAdmin(restAdmin);
		} catch (Exception e) {
			e.printStackTrace();
			restAdminUpdateStatus = "RestAdmin Update Failed";
		}
		return new ResponseEntity<String>(restAdminUpdateStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRestAdmin/{restID}", method = RequestMethod.GET, produces = "application/json")
	public RestAdmin getRestAdmin(@PathVariable("restID") String restId) {
		String sqlStatus = "Sql Success!";
		RestAdmin restAdmin = new RestAdmin();
		try {
			restAdmin = restAdminRepository.getRestAdmin(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return restAdmin;
	}
	
	
}
