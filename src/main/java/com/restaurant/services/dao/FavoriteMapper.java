package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Favorite;
import com.restaurant.services.model.Item;

public class FavoriteMapper implements RowMapper {
	
	public Favorite mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Favorite fav = new Favorite();
		
		fav.setCustId(rs.getString("custId"));
		fav.setRestId(rs.getString("favID"));
		fav.setRestName(rs.getString("favName"));
		
		return fav;
	}
}
