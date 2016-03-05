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
			"INSERT INTO Customers(firstName, middleName, lastName, emailAddress, password, promoCode, adChannel, insertDate) "
			+ "VALUES (:firstName,:middleName,:lastName,:email,:password,:promoCode,:adChannel,:insertDate)";
	
	public void registerCustomer(Customer customer){
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("firstName", customer.getFirstName());
		paramMap.put("middleName", customer.getMiddleName());
		paramMap.put("lastName", customer.getLastName());
		paramMap.put("email", customer.getEmail());
		paramMap.put("password", customer.getPassword());
		paramMap.put("promoCode", customer.getPromoCode());
		paramMap.put("adChannel", customer.getAdChannel());
		paramMap.put("insertDate", customer.getInsertDate());
		
		namedParameterTemplate.update(INSERT_CUSTOMER_RECORDS, paramMap);
	}

}
