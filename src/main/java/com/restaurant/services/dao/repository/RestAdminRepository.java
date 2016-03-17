package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.RestAdminMapper;
import com.restaurant.services.model.RestAdmin;
import com.restaurant.services.model.Restaurant;

@Component
public class RestAdminRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	private static final String INSERT_RESTADMIN_RECORDS = "INSERT INTO ResAdmin(resID, sales, numOrders, popularity, likes, "
			+ "dislikes, numRev, avgStar, numYelp, yelpStar, priceRange, recomenderID, recomType, commissionType, promoCode, "
			+ "adChannel, numCust, numRes) VALUES (:restId,:sales,:numOrders,:popularity,:likes,:dislikes,:numRev,:avgStar,"
			+ ":numYelp,:yelpStar,:priceRange,:recomenderID,:recomType,:commissionType,:promoCode,:adChannel,:numCust,:numRes)";

	private static final String UPDATE_RESTADMIN_RECORDS = "UPDATE ResAdmin SET sales=:sales,numOrders=:numOrders,"
			+ "popularity=:popularity,likes=:likes,dislikes=:dislikes,numRev=:numRev,avgStar=:avgStar,numYelp=:numYelp,"
			+ "yelpStar=:yelpStar,priceRange=:priceRange,recomenderID=:recomenderID,recomType=:recomType,commissionType=:commissionType,"
			+ "promoCode=:promoCode,adChannel=:adChannel,numCust=:numCust,numRes=:numRes WHERE resID = :restId";
	
	public void addToRestAdmin(RestAdmin restAdmin,String restId) {

		Map<String, Object> paramMap = createParameterMap(restAdmin);
		paramMap.put("restId", restId);
		namedParameterTemplate.update(INSERT_RESTADMIN_RECORDS, paramMap);
	}
	
	public void updateRestAdmin(RestAdmin restAdmin) {

		Map<String, Object> paramMap = createParameterMap(restAdmin);
		paramMap.put("restId", restAdmin.getRestID());
		namedParameterTemplate.update(UPDATE_RESTADMIN_RECORDS, paramMap);
	}
	
	public RestAdmin getRestAdmin(String restId) {  
		   String SQL = "SELECT * FROM ResAdmin WHERE resID = :restId ";
		   
		   SqlParameterSource namedParameters = new MapSqlParameterSource("restId", restId);
			
		   RestAdmin restAdmin = (RestAdmin) namedParameterTemplate.queryForObject(SQL, namedParameters, new RestAdminMapper());  
		     return restAdmin;  
		} 
	
	
private Map<String, Object> createParameterMap(RestAdmin restAdmin) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		//paramMap.put("restId", restAdmin.getRestID());
		paramMap.put("sales", restAdmin.getSales());
		paramMap.put("numOrders", restAdmin.getNumOrders());
		paramMap.put("popularity", restAdmin.getPopularity());
		paramMap.put("likes", restAdmin.getLikes());
		paramMap.put("dislikes", restAdmin.getDislikes());
		paramMap.put("numRev", restAdmin.getNumRev());
		paramMap.put("avgStar", restAdmin.getAvgStar());
		paramMap.put("numYelp", restAdmin.getNumYelp());
		paramMap.put("yelpStar", restAdmin.getYelpStar());
		paramMap.put("priceRange", restAdmin.getPriceRange());
		paramMap.put("recomenderID", restAdmin.getRecomenderID());
		paramMap.put("recomType", restAdmin.getRecomType());
		paramMap.put("commissionType", restAdmin.getCommissionType());
		paramMap.put("promoCode", restAdmin.getPromoCode());
		paramMap.put("adChannel", restAdmin.getAdChannel());
		paramMap.put("numCust", restAdmin.getNumCust());
		paramMap.put("numRes", restAdmin.getNumRes());
		
		return paramMap;
}
}