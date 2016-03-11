package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.ChoiceValues;

public class ChoiceValuesMapper implements RowMapper{
	
	public ChoiceValues mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		ChoiceValues chVal = new ChoiceValues();
		chVal.setRestId(rs.getString("resID"));
		chVal.setChNum(rs.getString("chNum"));
		chVal.setValueName(rs.getString("valueName"));
		chVal.setValuePrice(rs.getFloat("valuePrice"));
		chVal.setExtra(rs.getBoolean("extra"));
		
		return chVal;

	}
}
