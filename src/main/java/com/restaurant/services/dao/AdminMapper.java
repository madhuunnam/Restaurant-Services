package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Admin;

public class AdminMapper implements RowMapper {

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {

		Admin admin = new Admin();
		admin.setAdminId(rs.getString("adminID"));
		admin.setEmail(rs.getString("emailAddress"));
		admin.setPassword(rs.getString("password"));
		admin.setFirstName(rs.getString("firstName"));
		admin.setLastName(rs.getString("lastName"));
		admin.setMiddleName(rs.getString("lastName"));
		admin.setInsertDate(rs.getDate("insertDate"));
		admin.setPhone(rs.getString("telephoneNumber"));
		admin.setAddress(rs.getString("mailAddr"));
		admin.setOtherPhone(rs.getString("otherPhone"));
		admin.setSecQuest(rs.getString("question"));
		admin.setSecAns(rs.getString("answer"));

		return admin;
	}
}
