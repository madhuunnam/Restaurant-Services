package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Customer;

@Component
public class CustomerRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	
	private static final String INSERT_CUSTOMER_RECORDS = 
			"INSERT INTO Customers(firstName, lastName,insertDate) VALUES (:firstName,:lastName,:insertDate)";
	
	public void registerCustomer(Customer customer){
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("firstName", customer.getFirstName());
		paramMap.put("lastName", customer.getLastName());
		paramMap.put("insertDate", customer.getInsertDate());
		
		namedParameterTemplate.update(INSERT_CUSTOMER_RECORDS, paramMap);
	}

}
