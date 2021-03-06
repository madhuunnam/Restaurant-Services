package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.RestMapper;
import com.restaurant.services.model.Restaurant;

@Component
public class RestRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_REST_RECORDS = "INSERT INTO Restaurants(resName, altName, foundYear, categories, insertDate, "
			+ "hasMenu, telephoneNumber, otherPhone, addrStNum, city, state, zip, emailAddress, passwd, question, answer, website, "
			+ "closedDays, delivery, deliBy, deliMin, deliFee, deliPolicy, deliRadius, deliZips, deliStreets, pickup, dineIn, reserve, "
			+ "forKids, forGroup, parking, wifi, breakfast, lunch, dinner, lateNight, coupon, bankName, bankPhone, bankAddr, bankRouteNum, "
			+ "bankAccNum, mgrName, mgrPhone, mgrEmail, mgrPasswd,latitude,longitude,promoCode,adChannel) "
			+ "VALUES (:restName,:altName,:year,:categories,:insertDate,:hasMenu,:phone1,:phone2,:stAddress,:city,:state,:zip,:email,:password,"
			+ ":question,:ans,:website,:closedDays,:delivery,:deliBy,:deliMin,:deliFee,:deliPolicy,:deliRadius,:deliZips,:deliStreets,"
			+ ":pickUp,:dineIn,:reserve,:forKids,:forGroup,:parking,:wifi,:breakfast,:lunch,:dinner,:lateNight,:coupon,:bankName,:bankPhone,"
			+ ":bankAddr,:bankRouteNum,:bankAccNum,:mgrName,:mgrPhone,:mgrEmail,:mgrPasswd,:latitude,:longitude,:promoCode,:adChannel)";

	private static final String UPDATE_RESTAURANT_RECORDS = "UPDATE Restaurants SET resName=:restName,altName=:altName,foundYear=:year,"
			+ "categories=:categories,cancelDate=:cancelDate,hasMenu=:hasMenu,inputBy=:inputBy,note=:note,telephoneNumber=:phone1,"
			+ "otherPhone=:phone2,addrStNum=:stAddress,city=:city,state=:state,zip=:zip,latitude=:latitude,"
			+ "longitude=:longitude,emailAddress=:email,passwd=:password,question=:question,answer=:ans,website=:website,monFrom=:monFrom,"
			+ "monTo=:monTo,tueFrom=:tueFrom,tueTo=:tueTo,wedFrom=:wedFrom,wedTo=:wedTo,thuFrom=:thuFrom,thuTo=:thuTo,"
			+ "friFrom=:friFrom,friTo=:friTo,satFrom=:satFrom,satTo=:satTo,sunFrom=:sunFrom,sunTo=:sunTo,closedDays=:closedDays,"
			+ "delivery=:delivery,deliBy=:deliBy,deliMin=:deliMin,deliFee=:deliFee,deliPolicy=:deliPolicy,deliRadius=:deliRadius,"
			+ "deliZips=:deliZips,deliStreets=:deliStreets,pickup=:pickUp,dineIn=:dineIn,reserve=:reserve,forKids=:forKids,"
			+ "forGroup=:forGroup,parking=:parking,wifi=:wifi,breakfast=:breakfast,lunch=:lunch,dinner=:dinner,"
			+ "lateNight=:lateNight,coupon=:coupon,bankName=:bankName,bankPhone=:bankPhone,bankAddr=:bankAddr,bankRouteNum=:bankRouteNum,"
			+ "bankAccNum=:bankAccNum,mgrName=:mgrName,mgrPhone=:mgrPhone,mgrEmail=:mgrEmail,mgrPasswd=:mgrPasswd,promoCode=:promoCode,adChannel=:adChannel WHERE resID=:restId";

	public void registerRest(Restaurant rest) {

		Map<String, Object> paramMap = createParameterMap(rest);

		namedParameterTemplate.update(INSERT_REST_RECORDS, paramMap);
	}

	public void updateRestaurant(Restaurant rest) {

		Map<String, Object> paramMap = createParameterMap(rest);

		namedParameterTemplate.update(UPDATE_RESTAURANT_RECORDS, paramMap);
	}

	public List<Restaurant> listOfRestaurants() {
		String SQL = "SELECT * FROM Restaurants R, ResAdmin RA where R.resID = RA.resID";
		List<Restaurant> restaurants = (List<Restaurant>) namedParameterTemplate.query(SQL, new RestMapper());
		return restaurants;
	}

	public Restaurant getRestaurant(String restEmail) {
		String SQL = "SELECT * FROM Restaurants R, ResAdmin RA where R.emailAddress = :email and R.resID = RA.resID";

		System.out.println("The REST ID is " + restEmail);
		SqlParameterSource namedParameters = new MapSqlParameterSource("email", restEmail);

		Restaurant restaurant = (Restaurant) namedParameterTemplate.queryForObject(SQL, namedParameters,
				new RestMapper());
		return restaurant;
	}

	public String getNewRestaurantId() {

		String SQL = "SELECT max(resID) as resID FROM Restaurants ";

		String restID = namedParameterTemplate.getJdbcOperations().queryForObject(SQL, String.class);

		return restID;
	}

	public Restaurant getRestaurantById(String restID) {

		String SQL = "SELECT * from Restaurants r," + "ResAdmin ra where r.resID = :restId and r.resID = ra.resID ";

		SqlParameterSource namedParameters = new MapSqlParameterSource("restId", restID);

		Restaurant restaurant = new Restaurant();
		try {
			restaurant = (Restaurant) namedParameterTemplate.queryForObject(SQL, namedParameters, new RestMapper());
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}

		return restaurant;

	}

	private Map<String, Object> createParameterMap(Restaurant rest) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", rest.getRestID());
		paramMap.put("restName", rest.getRestName());
		paramMap.put("altName", rest.getAltName());
		paramMap.put("year", rest.getFoundYear());
		paramMap.put("categories", rest.getCategories());
		paramMap.put("insertDate", rest.getInsertDate());
		paramMap.put("cancelDate", rest.getCancelDate());
		paramMap.put("hasMenu", rest.getHasMenu());
		paramMap.put("inputBy", rest.getInputBy());
		paramMap.put("note", rest.getNote());

		paramMap.put("phone1", rest.getTelephoneNumber());
		paramMap.put("phone2", rest.getOtherPhone());
		paramMap.put("stAddress", rest.getStAddress());
		paramMap.put("city", rest.getCity());
		paramMap.put("state", rest.getState());
		paramMap.put("zip", rest.getZip());
		paramMap.put("latitude", rest.getLatitude());
		paramMap.put("longitude", rest.getLongitude());
		paramMap.put("email", rest.getEmail());
		paramMap.put("password", rest.getPassword());
		paramMap.put("question", rest.getSecurityQuest());
		paramMap.put("ans", rest.getSecAnswer());
		paramMap.put("website", rest.getWebsite());

		paramMap.put("monFrom", rest.getMonFrom());
		paramMap.put("monTo", rest.getMonTo());
		paramMap.put("tueFrom", rest.getTueFrom());
		paramMap.put("tueTo", rest.getTueTo());
		paramMap.put("tueFrom", rest.getTueFrom());
		paramMap.put("wedFrom", rest.getWedFrom());
		paramMap.put("wedTo", rest.getWedTo());
		paramMap.put("thuFrom", rest.getThuFrom());
		paramMap.put("thuTo", rest.getThuTo());
		paramMap.put("friFrom", rest.getFriFrom());
		paramMap.put("friTo", rest.getFriTo());
		paramMap.put("satFrom", rest.getSatFrom());
		paramMap.put("satTo", rest.getSatTo());
		paramMap.put("sunFrom", rest.getSunFrom());
		paramMap.put("sunTo", rest.getSunTo());
		paramMap.put("closedDays", rest.getClosedDays());

		paramMap.put("delivery", rest.getDelivery());
		paramMap.put("deliBy", rest.getDeliBy());
		// paramMap.put("deliMin", rest.getDeliMin());

		if (rest.getDeliMin() != null && !rest.getDeliMin().isEmpty()) {
			paramMap.put("deliMin", Float.parseFloat(rest.getDeliMin()));
		} else {
			paramMap.put("deliMin", null);
		}
		// paramMap.put("deliFee", rest.getDeliFee());
		if (rest.getDeliFee() != null && !rest.getDeliFee().isEmpty()) {
			paramMap.put("deliFee", Float.parseFloat(rest.getDeliFee()));
		} else {
			paramMap.put("deliFee", null);
		}

		paramMap.put("deliPolicy", rest.getDeliPolicy());
		// paramMap.put("deliRadius", rest.getDeliRadius());
		if (rest.getDeliRadius() != null && !rest.getDeliRadius().isEmpty()) {
			paramMap.put("deliRadius", Integer.parseInt(rest.getDeliRadius()));
		} else {
			paramMap.put("deliRadius", null);
		}
		paramMap.put("deliZips", rest.getDeliZips());
		paramMap.put("deliStreets", rest.getDeliStreets());

		paramMap.put("pickUp", rest.getPickup());
		paramMap.put("dineIn", rest.getDineIn());
		paramMap.put("reserve", rest.getReserve());
		paramMap.put("forKids", rest.getForKids());
		paramMap.put("forGroup", rest.getForGroup());
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
		paramMap.put("bankRouteNum", rest.getBankRouteNum());
		paramMap.put("bankAccNum", rest.getBankAccNum());
		paramMap.put("mgrName", rest.getMgrName());
		paramMap.put("mgrPhone", rest.getMgrPhone());
		paramMap.put("mgrEmail", rest.getMgrEmail());
		paramMap.put("mgrPasswd", rest.getMgrPasswd());
		
		paramMap.put("promoCode", rest.getPromoCode());
		paramMap.put("adChannel", rest.getAdChannel());

		return paramMap;
	}
}
