package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Favorite;

@Component
public class FavoriteRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_FAV_RECORDS = "INSERT INTO Favorites(custId, favID, favName) "
			+ "VALUES (:custId, :restId, :restName)";

	public void addFavorite(Favorite fav) {

		System.out.println("FAVORITE***"+fav.getRestId()+fav.getCustId()); 
	
		Map<String, Object> paramMap = createParameterMap(fav);

		namedParameterTemplate.update(INSERT_FAV_RECORDS, paramMap);
	}

	public List<Favorite> getFavRestaurantsForCustomer(String custId) {
		
		String SQL = "SELECT * FROM Favorites where custId = :custId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custId", custId);
		List<Favorite> favList = (List<Favorite>) namedParameterTemplate.query(SQL, paramMap, new FavoriteMapper());
		return favList;
	}

	public void deleteFavRestaurantForCust(String restId, String custId) {

		String SQL = "DELETE FROM Favorites where favID = :restId and custId =:custId";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("custId", custId);

		namedParameterTemplate.update(SQL, paramMap);

	}

	private Map<String, Object> createParameterMap(Favorite fav) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custId", fav.getCustId());
		paramMap.put("restId", fav.getRestId());
		paramMap.put("restName", fav.getRestName());

		return paramMap;
	}

}
