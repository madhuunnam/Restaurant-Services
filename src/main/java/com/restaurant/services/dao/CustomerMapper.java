package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Customer;

public class CustomerMapper implements RowMapper {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer cust = new Customer();
		cust.setCustID(rs.getString("custID"));
		cust.setEmail(rs.getString("emailAddress"));
		cust.setPassword(rs.getString("password"));
		cust.setFirstName(rs.getString("firstName"));
		cust.setLastName(rs.getString("lastName"));
		cust.setMiddleName(rs.getString("lastName"));
		cust.setInsertDate(rs.getDate("insertDate"));
		cust.setPhone(rs.getString("telephoneNumber"));
		cust.setPromoCode(rs.getString("promoCode"));
		cust.setAdChannel(rs.getString("adChannel"));
		cust.setStAddress(rs.getString("addrStNum"));
		cust.setCity(rs.getString("city"));
		cust.setState(rs.getString("state"));
		cust.setZip(rs.getString("zip"));
		
		return cust;
	} 
}
