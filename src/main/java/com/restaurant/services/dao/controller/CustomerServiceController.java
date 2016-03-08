package com.restaurant.services.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.CustomerRepository;
import com.restaurant.services.model.Customer;

@RestController
public class CustomerServiceController {
	
	@Autowired
	CustomerRepository customerRepository;

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
	
	@RequestMapping(value = "/getCustomer/{customerEmail:.+}", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomer(@PathVariable("customerEmail") String customerEmail) {
		String sqlStatus = "Sql Success!";
		Customer customer = new Customer();
		System.out.println("THE CUST ID IS " + customerEmail );
		try {
			customer = customerRepository.getCustomer(customerEmail);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return customer;
	}
	

}
