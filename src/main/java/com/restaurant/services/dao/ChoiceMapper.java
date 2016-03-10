package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Choice;

public class ChoiceMapper implements RowMapper {

	public Choice mapRow(ResultSet rs, int rowNum) throws SQLException {

		Choice choice = new Choice();
		choice.setRestId(rs.getString("resID"));
		choice.setItemNum(rs.getString("itemNum"));
		choice.setChNum(rs.getString("chNum"));
		choice.setChTitle(rs.getString("chTitle"));
		choice.setChType(rs.getString("chType"));
		choice.setRequired(rs.getBoolean("required"));
		choice.setNumValue(rs.getInt("numValue"));
		return choice;

	}
}
