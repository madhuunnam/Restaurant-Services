package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Item;

public class ItemMapper implements RowMapper {

	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

		Item item = new Item();
		item.setRestId(rs.getString("resID"));
		item.setItemNum(rs.getString("itemNum"));
		item.setItemName(rs.getString("itemName"));
		item.setSecName(rs.getString("secName"));
		item.setDescription(rs.getString("description"));
		item.setBasePrice(rs.getFloat("basePrice"));
		item.setNumChoice(rs.getInt("numChoice"));
		return item;

	}
}
