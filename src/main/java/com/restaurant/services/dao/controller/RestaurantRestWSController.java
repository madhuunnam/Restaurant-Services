package com.restaurant.services.dao.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.CustomerRepository;
import com.restaurant.services.model.Customer;

@RestController
public class RestaurantRestWSController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@RequestMapping(value= "/ping" , method= RequestMethod.GET,produces="application/json")
    public Customer ping() {
		
		Customer customer = new Customer ();
		customer.setFirstName("Subhash");
		customer.setLastName("Koganti123");
		customer.setInsertDate(new Date());
		System.out.println("Subhash is testing REST Service ping");
		customerRepository.registerCustomer(customer);
	
        return customer;
    }

}
