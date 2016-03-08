package com.restaurant.services.dao.controller;


import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class RestaurantServiceController {

	@Autowired
	RestRepository restRepository;

//	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
//	public Associate ping() {
//
//		Associate assoc = new Associate();
//		assoc.setFirstName("Madhu");
//		assoc.setLastName("Unnam");
//		assoc.setInsertDate(new Date());
//		System.out.println("Madhu is testing REST Service ping");
//		// customerRepository.registerCustomer(customer);
//
//		return assoc;
//	}

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
	
	@RequestMapping(value = "/getRestaurantList", method = RequestMethod.GET, produces = "application/json")
	public List<Restaurant> restaurantList() {
		String sqlStatus = "Sql Success!";
		List<Restaurant> rests = null;
		try {
			rests = restRepository.listOfRestaurants();
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return rests;
	}
	
	@RequestMapping(value = "/getRestaurant/{restaurantEmail:.+}", method = RequestMethod.GET, produces = "application/json")
	public Restaurant getRestaurant(@PathVariable("restaurantEmail") String restaurantEmail) {
		String sqlStatus = "Sql Success!";
		Restaurant restaurant = new Restaurant();
		
		System.out.println("THE REST ID IS " + restaurantEmail );
		try {
			restaurant = restRepository.getRestaurant(restaurantEmail);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return restaurant;
	}
	
}
