package com.restaurant.services.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.RestRepository;
import com.restaurant.services.model.Restaurant;

@RestController
public class RestaurantServiceController {

	@Autowired
	RestRepository restRepository;

//	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = "application/json")
//	public Restaurant ping() {
//
//		Restaurant admin = new Restaurant();
//		admin.setAltName("Madhu");
//		admin.setRestName("Unnam");
//		admin.setInsertDate(new Date());
//		System.out.println("Madhu is testing REST Service ping");
//		// customerRepository.registerCustomer(customer);
//
//		return admin;
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
	
	@RequestMapping(value = "/updateRestaurantProfile", method = RequestMethod.PUT)
	public ResponseEntity<String> updateRestaurant(@RequestBody Restaurant restaurant) {
		String restaurantUpdateStatus = "Restaurant Update Success!";
		try {
			restRepository.updateRestaurant(restaurant);
		} catch (Exception e) {
			e.printStackTrace();
			restaurantUpdateStatus = "Restaurant Update Failed";
		}
		return new ResponseEntity<String>(restaurantUpdateStatus, HttpStatus.OK);
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
			restaurant= null;
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return restaurant;
	}
	
	@RequestMapping(value = "/getNewRestaurantId", method = RequestMethod.GET, produces = "application/json")
	public String getNewRestaurantId() {
		
		String sqlStatus = "Sql Success!";
		String restId="";
		try {
			restId = restRepository.getNewRestaurantId();
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return restId;
	}
	
	@RequestMapping(value = "/getRestaurantById/{restID}", method = RequestMethod.GET, produces = "application/json")
	public Restaurant getRestaurantById(@PathVariable("restID") String restId) {
		
		String sqlStatus = "Sql Success!";
		Restaurant rest = null;
		try {
			rest = restRepository.getRestaurantById(restId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return rest;
	}
	
}
