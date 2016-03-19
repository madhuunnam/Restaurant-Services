package com.restaurant.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.CustomerRepository;
import com.restaurant.services.model.Admin;
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
	
	@RequestMapping(value = "/updateCustomerProfile", method = RequestMethod.PUT)
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		String customerUpdateStatus = "Customer Update Success!";
		try {
			customerRepository.updateCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
			customerUpdateStatus = "Customer Update Failed";
		}
		return new ResponseEntity<String>(customerUpdateStatus, HttpStatus.OK);
	}
	@RequestMapping(value = "/getCustomer/{customerEmail:.+}", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomer(@PathVariable("customerEmail") String customerEmail) {
		String sqlStatus = "Sql Success!";
		Customer customer = new Customer();
		System.out.println("THE CUST ID IS " + customerEmail );
		try {
			customer = customerRepository.getCustomer(customerEmail);
		} catch (EmptyResultDataAccessException e) {
			customer= null;
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return customer;
	}
	
	@RequestMapping(value = "/getNewCustomerId", method = RequestMethod.GET, produces = "application/json")
	public String getNewCustomerId() {
		
		String sqlStatus = "Sql Success!";
		String custId="";
		try {
			custId = customerRepository.getNewCustomerId();
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return custId;
	}
	
	@RequestMapping(value = "/getCustomerById/{custID}", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomerById(@PathVariable("custID") String custId) {
		
		String sqlStatus = "Sql Success!";
		Customer cust = null;
		try {
			cust = customerRepository.getCustomerById(custId);
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return cust;
	}
	

}
