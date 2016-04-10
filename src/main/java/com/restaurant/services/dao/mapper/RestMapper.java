package com.restaurant.services.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.jdbc.core.RowMapper;

import com.restaurant.services.model.Restaurant;

public class RestMapper implements RowMapper {

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

		rest.setMonFrom(getDateFromTime(rs.getTime("monFrom")));
		rest.setMonTo(getDateFromTime(rs.getTime("monTo")));
		rest.setTueFrom(getDateFromTime(rs.getTime("tueFrom")));
		rest.setTueTo(getDateFromTime(rs.getTime("tueTo")));
		rest.setWedFrom(getDateFromTime(rs.getTime("wedFrom")));
		rest.setWedTo(getDateFromTime(rs.getTime("wedTo")));
		rest.setThuFrom(getDateFromTime(rs.getTime("thuFrom")));
		rest.setThuTo(getDateFromTime(rs.getTime("thuTo")));
		rest.setFriFrom(getDateFromTime(rs.getTime("friFrom")));
		rest.setFriTo(getDateFromTime(rs.getTime("friTo")));
		rest.setSatFrom(getDateFromTime(rs.getTime("satFrom")));
		rest.setSatTo(getDateFromTime(rs.getTime("satTo")));
		rest.setSunFrom(getDateFromTime(rs.getTime("sunFrom")));
		rest.setSunTo(getDateFromTime(rs.getTime("sunTo")));

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

		rest.setPromoCode(rs.getString("promoCode"));
		rest.setAdChannel(rs.getString("adChannel"));

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
		rest.getRestAdmin().setNumCust(rs.getInt("numCust"));
		rest.getRestAdmin().setNumRes(rs.getInt("numRes"));

		return rest;
	}

	private Date getDateFromTime(Time time) {

		Calendar c = Calendar.getInstance();
		if(time!=null){
			c.setTime(time);
			return c.getTime();
		}else{
			c.set(Calendar.HOUR_OF_DAY, 1);
	        c.set(Calendar.MINUTE, 0);
	        c.set(Calendar.SECOND, 0);
	        c.set(Calendar.MILLISECOND, 0);
//	        c.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
//			return c.getTime();
	        return null;
		}
	}
}