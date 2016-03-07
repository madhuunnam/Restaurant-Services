package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Customer;

@Component
public class CustomerRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	
	private static final String INSERT_CUSTOMER_RECORDS = 
			"INSERT INTO Customers(firstName, middleName, lastName, emailAddress, password, promoCode, adChannel, insertDate, "
			+ "telephoneNumber, addrStNum, city, state, zip) "
			+ "VALUES (:firstName,:middleName,:lastName,:email,:password,:promoCode,:adChannel,:insertDate,"
			+ ":phone,:stAddress,:city,:state,:zip)";
	
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
		paramMap.put("phone", customer.getPhone());
		paramMap.put("stAddress", customer.getStAddress());
		paramMap.put("city", customer.getCity());
		paramMap.put("state", customer.getState());
		paramMap.put("zip", customer.getZip());
		
		namedParameterTemplate.update(INSERT_CUSTOMER_RECORDS, paramMap);
	}
	
	public boolean verifyLogin(String custEmail,String custPwd){
		
		String CHECK_LOGIN_SQL = "SELECT * from Customers where emailAddress = :email ";

		SqlParameterSource namedParameters = new MapSqlParameterSource("email",custEmail);
		
		Customer cust = (Customer) namedParameterTemplate.queryForObject(CHECK_LOGIN_SQL, namedParameters, new CustomerMapper());

		if(cust.getEmail().equals(custEmail) && cust.getPassword().equals(custPwd)){
			return true;
		}
		return false;
	}
	
	
}
