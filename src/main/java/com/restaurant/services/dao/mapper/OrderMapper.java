package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Order;

public class OrderMapper implements RowMapper{
public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order or = new Order();
		
		
		return or;
} 
}
