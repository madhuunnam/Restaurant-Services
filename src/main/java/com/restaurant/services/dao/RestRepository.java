package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Customer;
import com.restaurant.services.model.Restaurant;

@Component
public class RestRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_REST_RECORDS = "INSERT INTO Restaurants(resName, altName, foundYear, categories, insertDate, "
			+ "hasMenu, telephoneNumber, otherPhone, addrStNum, city, state, zip, emailAddress, passwd, question, answer, website, "
			+ "closedDays, delivery, deliBy, deliMin, deliFee, deliPolicy, deliRadius, deliZips, deliStreets, pickup, dineIn, reserve, "
			+ "forKids, forGroup, parking, wifi, breakfast, lunch, dinner, lateNight, coupon, bankName, bankPhone, bankAddr, bankRouteNum, "
			+ "bankAccNum, mgrName, mgrPhone, mgrEmail, mgrPasswd) "
			+ "VALUES (:restName,:altName,:year,:category,:insertDate,:hasMenu,:phone1,:phone2,:stAddress,:city,:state,:zip,:email,:pwd,"
			+ ":secQuest,:secAns,:website,:closedDays,:delivery,:deliBy,:deliMin,:deliFee,:deliPolicy,:deliRadius,:deliZips,:deliStreets,"
			+ ":pickUp,:dineIn,:reserve,:forKids,:forGrp,:parking,:wifi,:breakfast,:lunch,:dinner,:lateNight,:coupon,:bankName,:bankPhone,"
			+ ":bankAddr,:bankRouteNo,:bankAccNo,:mgrName,:mgrPhone,:mgrEmail,:mgrPwd)";

	public void registerRest(Restaurant rest) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restName", rest.getRestName());
		paramMap.put("altName", rest.getAltName());
		paramMap.put("year", rest.getFoundYear());
		paramMap.put("category", rest.getCategories());
		paramMap.put("insertDate", rest.getInsertDate());
		paramMap.put("hasMenu", rest.getHasMenu());
		paramMap.put("phone1", rest.getTelephoneNumber());
		paramMap.put("phone2", rest.getOtherPhone());
		paramMap.put("stAddress", rest.getStAddress());
		paramMap.put("city", rest.getCity());
		paramMap.put("state", rest.getState());
		paramMap.put("zip", rest.getZip());
		paramMap.put("email", rest.getEmail());
		paramMap.put("pwd", rest.getPassword());
		paramMap.put("secQuest", rest.getSecurityQuest());
		paramMap.put("secAns", rest.getSecAnswer());
		paramMap.put("website", rest.getWebsite());
		paramMap.put("closedDays", rest.getClosedDays());
		paramMap.put("delivery", rest.getDelivery());
		paramMap.put("deliBy", rest.getDeliBy());
		paramMap.put("deliMin", rest.getDeliMin());
		paramMap.put("deliFee", rest.getDeliFee());
		paramMap.put("deliPolicy", rest.getDeliPolicy());
		paramMap.put("deliRadius", rest.getDeliRadius());
		paramMap.put("deliZips", rest.getDeliZips());
		paramMap.put("deliStreets", rest.getDeliStreets());
		paramMap.put("pickUp", rest.getPickup());
		paramMap.put("dineIn", rest.getDineIn());
		paramMap.put("reserve", rest.getReserve());
		paramMap.put("forKids", rest.getForKids());
		paramMap.put("forGrp", rest.getForGroup());
		paramMap.put("parking", rest.getParking());
		paramMap.put("wifi", rest.getWifi());
		paramMap.put("breakfast", rest.getBreakfast());
		paramMap.put("lunch", rest.getLunch());
		paramMap.put("dinner", rest.getDinner());
		paramMap.put("lateNight", rest.getLateNight());
		paramMap.put("coupon", rest.getCoupon());
		paramMap.put("bankName", rest.getBankName());
		paramMap.put("bankPhone", rest.getBankPhone());
		paramMap.put("bankAddr", rest.getBandAddr());
		paramMap.put("bankRouteNo", rest.getBankRouteNum());
		paramMap.put("bankAccNo", rest.getBankAccNum());
		paramMap.put("mgrName", rest.getMgrName());
		paramMap.put("mgrPhone", rest.getMgrPhone());
		paramMap.put("mgrEmail", rest.getMgrEmail());
		paramMap.put("mgrPwd", rest.getMgrPasswd());

		namedParameterTemplate.update(INSERT_REST_RECORDS, paramMap);
	}
	
	public boolean verifyLogin(String restEmail,String restPwd){
		
		String CHECK_LOGIN_SQL = "SELECT * from Restaurants where emailAddress = :email ";

		SqlParameterSource namedParameters = new MapSqlParameterSource("email",restEmail);
		
		Restaurant rest = (Restaurant) namedParameterTemplate.queryForObject(CHECK_LOGIN_SQL, namedParameters, new RestMapper());
		
		if(rest.getEmail().equals(restEmail) && rest.getPassword().equals(restPwd)){
			return true;
		}
		return false;
	}

	public List<Restaurant> listOfRestaurants() {  
		   String SQL = "SELECT * FROM Restaurants";  
		   List<Restaurant> restaurants = (List<Restaurant>) namedParameterTemplate.query(SQL, new RestMapper());  
		     return restaurants;  
		} 
	
	public Restaurant getRestaurant(String restEmail) {  
		   String SQL = "SELECT * FROM Restaurants where emailAddress = :email ";
		   
		   System.out.println("The REST ID is " +restEmail);
		   SqlParameterSource namedParameters = new MapSqlParameterSource("email", restEmail);
			
		   Restaurant restaurant = (Restaurant) namedParameterTemplate.queryForObject(SQL, namedParameters, new RestMapper());  
		     return restaurant;  
		} 
}
