package com.restaurant.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.RestAdmin;

public class RestAdminMapper implements RowMapper{

	public RestAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RestAdmin ra = new RestAdmin();
		
		ra.setRestID(rs.getString("resID"));
		ra.setSales(rs.getFloat("sales"));
		ra.setNumOrders(rs.getInt("numOrders"));
		ra.setPopularity(rs.getFloat("popularity"));
		ra.setLikes(rs.getInt("likes"));
		ra.setDislikes(rs.getInt("dislikes"));
		ra.setNumRev(rs.getInt("numRev"));
		ra.setAvgStar(rs.getFloat("avgStar"));
		ra.setNumYelp(rs.getInt("numYelp"));
		ra.setYelpStar(rs.getFloat("yelpStar"));
		ra.setPriceRange(rs.getString("priceRange"));
		ra.setRecomenderID(rs.getInt("recomenderID"));
		ra.setRecomType(rs.getString("recomType"));
		ra.setCommissionType(rs.getString("commissionType"));
		ra.setPromoCode(rs.getString("promoCode"));
		ra.setAdChannel(rs.getString("adChannel"));
		ra.setNumCust(rs.getInt("numCust"));
		ra.setNumRes(rs.getInt("numRes"));
		
		return ra;
	}

}
