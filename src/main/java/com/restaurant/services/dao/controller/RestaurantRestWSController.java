package com.restaurant.services.dao.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.AdminRepository;
import com.restaurant.services.dao.AssociateRepository;
import com.restaurant.services.dao.CustomerRepository;
import com.restaurant.services.dao.RestRepository;
import com.restaurant.services.model.Admin;
import com.restaurant.services.model.Associate;
import com.restaurant.services.model.Customer;
import com.restaurant.services.model.Restaurant;

@RestController
public class RestaurantRestWSController {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	RestRepository restRepository;
	@Autowired
	AssociateRepository assocRepository;
	@Autowired
	AdminRepository adminRepository;
	

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
	public Customer ping() {

		Customer customer = new Customer();
		customer.setFirstName("Subhash");
		customer.setLastName("Koganti123");
		customer.setInsertDate(new Date());
		System.out.println("Subhash is testing REST Service ping");
		// customerRepository.registerCustomer(customer);

		return customer;
	}

	@RequestMapping(value = "/signUpCustomer", method = RequestMethod.POST)
	public ResponseEntity<String> registerCust(@RequestBody Customer cust) {

		String insertStatus = "Customer Regitration Success! Please Login";
		System.out.println(cust.toString());
		try {
			customerRepository.registerCustomer(cust);
		} catch (Exception e) {
			e.printStackTrace();
			insertStatus = "Customer Regitration Failed";
		}
		return new ResponseEntity<String>(insertStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/signUpRestaurant", method = RequestMethod.POST)
	public ResponseEntity<String> registerRest(@RequestBody Restaurant rest) {
		System.out.println(rest.getRestName());
		String restInsertStatus = "Restaurant Regitration Success! Please Login";
		try {
			restRepository.registerRest(rest);
		} catch (Exception e) {
			e.printStackTrace();
			restInsertStatus = "Restaurant Regitration Failed";
		}
	return new ResponseEntity<String>(restInsertStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/signUpAssociate", method = RequestMethod.POST)
	public ResponseEntity<String> registerAssociate(@RequestBody Associate assoc) {
		String assocInsertStatus = "Associate Regitration Success! Please Login";
		try {
			assocRepository.registerAssociate(assoc);
		} catch (Exception e) {
			e.printStackTrace();
			assocInsertStatus = "Associate Regitration Failed";
		}
	return new ResponseEntity<String>(assocInsertStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/signUpAdmin", method = RequestMethod.POST)
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
		String adminInsertStatus = "Admin Regitration Success! Please Login";
		try {
			adminRepository.registerAdmin(admin);
		} catch (Exception e) {
			e.printStackTrace();
			adminInsertStatus = "Admin Regitration Failed";
		}
	return new ResponseEntity<String>(adminInsertStatus, HttpStatus.OK);
	}

}
