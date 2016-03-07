package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Restaurant;

public class RestMapper implements RowMapper{

public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Restaurant rest = new Restaurant();
		rest.setEmail(rs.getString("emailAddress"));
		rest.setPassword(rs.getString("passwd"));
		rest.setInsertDate(rs.getDate("insertDate"));
		rest.setStAddress(rs.getString("addrStNum"));
		rest.setCity(rs.getString("city"));
		rest.setState(rs.getString("state"));
		rest.setZip(rs.getString("zip"));
		
		return rest;
	} 
}