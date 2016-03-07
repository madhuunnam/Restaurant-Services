package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Associate;

public class AssociateMapper implements RowMapper {

	public Associate mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Associate assoc = new Associate();
		assoc.setAssocID(rs.getString("assocID"));
		assoc.setEmail(rs.getString("emailAddress"));
		assoc.setPassword(rs.getString("password"));
		assoc.setFirstName(rs.getString("firstName"));
		assoc.setLastName(rs.getString("lastName"));
		assoc.setMiddleName(rs.getString("lastName"));
		assoc.setInsertDate(rs.getDate("joinDate"));
		assoc.setPhone(rs.getString("telephoneNumber"));
		assoc.setPromoCode(rs.getString("promoCode"));
		assoc.setAdChannel(rs.getString("adChannel"));
		assoc.setStAddress(rs.getString("addrStNum"));
		assoc.setCity(rs.getString("city"));
		assoc.setState(rs.getString("state"));
		assoc.setZip(rs.getString("zip"));
		
		return assoc;
	} 
}
