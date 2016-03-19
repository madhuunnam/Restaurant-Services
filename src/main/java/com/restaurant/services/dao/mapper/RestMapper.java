package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Restaurant;

public class RestMapper implements RowMapper{

public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Restaurant rest = new Restaurant();
		
		rest.setRestID(rs.getString("resID"));
		rest.setRestName(rs.getString("resName"));
		rest.setAltName(rs.getString("altName"));
		rest.setFoundYear(rs.getString("foundYear"));
		rest.setCategories(rs.getString("categories"));
		rest.setInsertDate(rs.getDate("insertDate"));
		rest.setCancelDate(rs.getDate("cancelDate"));
		rest.setHasMenu(rs.getString("hasMenu"));
		rest.setInputBy(rs.getString("inputBy"));
		rest.setNote(rs.getString("note"));
		
		rest.setTelephoneNumber(rs.getString("telephoneNumber"));
		rest.setOtherPhone(rs.getString("otherPhone"));
		rest.setStAddress(rs.getString("addrStNum"));
		rest.setCity(rs.getString("city"));
		rest.setState(rs.getString("state"));
		rest.setZip(rs.getString("zip"));
		rest.setLatitude(rs.getFloat("latitude"));
		rest.setLongitude(rs.getFloat("longitude"));
		
		rest.setEmail(rs.getString("emailAddress"));
		rest.setPassword(rs.getString("passwd"));
		rest.setSecurityQuest(rs.getString("question"));
		rest.setSecAnswer(rs.getString("answer"));
		rest.setWebsite(rs.getString("website"));
		
//		rest.setMonFrom(rs.getTimestamp("monFrom"));
//		rest.setMonTo(rs.getTimestamp("monTo"));
//		rest.setTueFrom(rs.getTimestamp("tueFrom"));
//		rest.setTueTo(rs.getTimestamp("tueTo"));
//		rest.setWedFrom(rs.getTimestamp("wedFrom"));
//		rest.setWedTo(rs.getTimestamp("wedTo"));
//		rest.setThuFrom(rs.getTimestamp("thuFrom"));
//		rest.setThuTo(rs.getTimestamp("thuTo"));
//		rest.setFriFrom(rs.getTimestamp("friFrom"));
//		rest.setFriTo(rs.getTimestamp("friTo"));
//		rest.setSatFrom(rs.getTimestamp("satFrom"));
//		rest.setSatTo(rs.getTimestamp("satTo"));
//		rest.setSunFrom(rs.getTimestamp("sunFrom"));
//		rest.setSunTo(rs.getTimestamp("sunTo"));
		rest.setClosedDays(rs.getString("closedDays"));
		
		rest.setDelivery(rs.getString("delivery"));
		rest.setDeliBy(rs.getString("deliBy"));
		rest.setDeliFee(rs.getString("deliMin"));
		rest.setDeliFee(rs.getString("deliFee"));
		rest.setDeliPolicy(rs.getString("deliPolicy"));
		rest.setDeliRadius(rs.getString("deliRadius"));
		rest.setDeliZips(rs.getString("deliZips"));
		rest.setDeliStreets(rs.getString("deliStreets"));
		
		rest.setPickup(rs.getString("pickup"));
		rest.setDineIn(rs.getString("dineIn"));
		rest.setReserve(rs.getString("reserve"));
		rest.setForKids(rs.getString("forKids"));
		rest.setForGroup(rs.getString("forGroup"));
		rest.setParking(rs.getString("parking"));
		rest.setWifi(rs.getString("wifi"));
		rest.setBreakfast(rs.getString("breakfast"));
		rest.setLunch(rs.getString("lunch"));
		rest.setDinner(rs.getString("dinner"));
		rest.setLateNight(rs.getString("lateNight"));
		rest.setCoupon(rs.getString("coupon"));
		
		rest.setBankName(rs.getString("bankName"));
		rest.setBankPhone(rs.getString("bankPhone"));
		rest.setBandAddr(rs.getString("bankAddr"));
		rest.setBankRouteNum(rs.getString("bankRouteNum"));
		rest.setBankAccNum(rs.getString("bankAccNum"));
		
		rest.setMgrName(rs.getString("mgrName"));
		rest.setMgrPhone(rs.getString("mgrPhone"));
		rest.setMgrEmail(rs.getString("mgrEmail"));
		rest.setMgrPasswd(rs.getString("mgrPasswd"));
		
		rest.getRestAdmin().setSales(rs.getFloat("sales"));
		rest.getRestAdmin().setNumOrders(rs.getInt("numOrders"));
		rest.getRestAdmin().setPopularity(rs.getFloat("popularity"));
		rest.getRestAdmin().setLikes(rs.getInt("likes"));
		rest.getRestAdmin().setDislikes(rs.getInt("dislikes"));
		rest.getRestAdmin().setNumRev(rs.getInt("numRev"));
		rest.getRestAdmin().setAvgStar(rs.getFloat("avgStar"));
		rest.getRestAdmin().setNumYelp(rs.getInt("numYelp"));
		rest.getRestAdmin().setYelpStar(rs.getFloat("yelpStar"));
		rest.getRestAdmin().setPriceRange(rs.getString("priceRange"));
		rest.getRestAdmin().setRecomenderID(rs.getInt("recomenderID"));
		rest.getRestAdmin().setRecomType(rs.getString("recomType"));
		rest.getRestAdmin().setCommissionType(rs.getString("commissionType"));
		rest.getRestAdmin().setPromoCode(rs.getString("promoCode"));
		rest.getRestAdmin().setAdChannel(rs.getString("adChannel"));
		rest.getRestAdmin().setNumCust(rs.getInt("numCust"));
		rest.getRestAdmin().setNumRes(rs.getInt("numRes"));
		
		return rest;
	} 
}