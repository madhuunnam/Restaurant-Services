package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.LineItem;

public class LineItemMapper implements RowMapper {

	public LineItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		LineItem item = new LineItem();
		item.setRestId(rs.getString("resID"));
		item.setOrderNo(rs.getString("orderNum"));
		item.setLineNum(rs.getString("lineNum"));
		item.setItemNum(rs.getInt("itemNum"));
		item.setItemName(rs.getString("itemName"));
		item.setChoiceText(rs.getString("choiceText"));
		item.setQuantity(rs.getInt("quantity"));
		item.setPrice(rs.getFloat("price"));
		item.setNote(rs.getString("note"));
		return item;

	}
}

