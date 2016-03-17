package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Associate;

public class AssociateMapper implements RowMapper {

	public Associate mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Associate assoc = new Associate();
		assoc.setAssocID(rs.getString("assocID"));
		assoc.setInsertDate(rs.getDate("joinDate"));
		assoc.setLeaveDate(rs.getDate("leaveDate"));
		
		assoc.setFirstName(rs.getString("firstName"));
		assoc.setLastName(rs.getString("lastName"));
		assoc.setMiddleName(rs.getString("middleName"));
		assoc.setNickName(rs.getString("nickName"));
		
		assoc.setPhone(rs.getString("telephoneNumber"));
		assoc.setOtherPhone(rs.getString("otherPhone"));
		assoc.setStAddress(rs.getString("addrStNum"));
		assoc.setCity(rs.getString("city"));
		assoc.setState(rs.getString("state"));
		assoc.setZip(rs.getString("zip"));
		assoc.setEmail(rs.getString("emailAddress"));
		assoc.setPassword(rs.getString("password"));
		
		assoc.setBankName(rs.getString("bankName"));
		assoc.setBankRouteNum(rs.getString("bankRouteNum"));
		assoc.setBankAccNum(rs.getString("bankAccNum"));
		assoc.setComType(rs.getString("comType"));
		assoc.setPreTye(rs.getString("preTye"));
		assoc.setChgDate(rs.getDate("chgDate"));
		
		assoc.setUplineID(rs.getString("uplineID"));
		assoc.setUplineName(rs.getString("uplineName"));
		assoc.setGparID(rs.getString("gparID"));
		assoc.setGparName(rs.getString("gparName"));
		assoc.setGgparID(rs.getString("ggparID"));
		assoc.setGgparName(rs.getString("ggparName"));
		
		assoc.setPromoCode(rs.getString("promoCode"));
		assoc.setAdChannel(rs.getString("adChannel"));
		
		
		return assoc;
	} 
}
