package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Customer;

public class CustomerMapper implements RowMapper {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer cust = new Customer();
		cust.setCustID(rs.getString("custID"));
		cust.setInsertDate(rs.getDate("insertDate"));
		cust.setCancelDate(rs.getDate("cancelDate"));
		cust.setFirstName(rs.getString("firstName"));
		cust.setLastName(rs.getString("lastName"));
		cust.setMiddleName(rs.getString("lastName"));
		cust.setNickName(rs.getString("nickName"));
		cust.setPhone(rs.getString("telephoneNumber"));
		cust.setOtherPhone(rs.getString("otherPhone"));
		cust.setStAddress(rs.getString("addrStNum"));
		cust.setCity(rs.getString("city"));
		cust.setState(rs.getString("state"));
		cust.setZip(rs.getString("zip"));
		cust.setLatitude(rs.getFloat("latitude"));
		cust.setLongitude(rs.getFloat("longitude"));
		cust.setEmail(rs.getString("emailAddress"));
		cust.setPassword(rs.getString("password"));
		
		cust.setCardNumber(rs.getString("cardNumber"));
		cust.setCardType(rs.getString("cardType"));
		cust.setCardName(rs.getString("cardName"));
		cust.setCardExp(rs.getDate("cardExp"));
		cust.setCardCode(rs.getString("cardCode"));
		cust.setBillZip(rs.getString("billZip"));
		cust.setBillAddr(rs.getString("billAddr"));
		
		cust.setCardNumber1(rs.getString("cardNumber1"));
		cust.setCardType1(rs.getString("cardType1"));
		cust.setCardName1(rs.getString("cardName1"));
		cust.setCardExp1(rs.getDate("cardExp1"));
		cust.setCardCode1(rs.getString("cardCode1"));
		cust.setBillZip1(rs.getString("billZip1"));
		cust.setBillAddr1(rs.getString("billAddr1"));
		cust.setPaypalNum(rs.getString("paypalNum"));
	
		cust.setRecomenderID(rs.getString("recomenderID"));
		cust.setRecomType(rs.getString("recomType"));
		cust.setPromoCode(rs.getString("promoCode"));
		cust.setAdChannel(rs.getString("adChannel"));
		
		
		return cust;
	} 
}
