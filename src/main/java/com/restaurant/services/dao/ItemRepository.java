package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Item;

@Component
public class ItemRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_ITEM_RECORDS = "INSERT INTO Items(resID, itemNum, secName, itemName, description, basePrice, numChoice) "
			+ "VALUES (:restId,:itemNum,:secName,:itemName,:description,:basePrice,:numChoice)";

	private static final String UPDATE_ITEM_RECORDS = "UPDATE Items SET secName=:secName,itemName=:itemName,description=:description,"
			+ "basePrice=:basePrice,numChoice=:numChoice WHERE resID =:restId and itemNum =:itemNum";

	public void addItem(Item item) {

		Map<String, Object> paramMap = createParameterMap(item);

		namedParameterTemplate.update(INSERT_ITEM_RECORDS, paramMap);
	}

	public void updateItem(Item item) {

		Map<String, Object> paramMap = createParameterMap(item);

		namedParameterTemplate.update(UPDATE_ITEM_RECORDS, paramMap);
	}

	public List<Item> getItemListForRestaurant(String restId) {
		String SQL = "SELECT * FROM Items where resID = :restId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		List<Item> itemsOfRestaurant = (List<Item>) namedParameterTemplate.query(SQL, paramMap, new ItemMapper());
		return itemsOfRestaurant;
	}

	private Map<String, Object> createParameterMap(Item item) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", item.getRestId());
		paramMap.put("itemNum", item.getItemNum());
		paramMap.put("secName", item.getSecName());
		paramMap.put("itemName", item.getItemName());
		paramMap.put("description", item.getDescription());
		paramMap.put("basePrice", item.getBasePrice());
		paramMap.put("numChoice", item.getNumChoice());
		return paramMap;
	}

}
