package com.restaurant.services.dao.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.ItemMapper;
import com.restaurant.services.model.Choice;
import com.restaurant.services.model.Item;

@Component
public class ItemRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	@Autowired
	ChoiceRepository choiceRepository;

	private static final String INSERT_ITEM_RECORDS = "INSERT INTO Items(resID, itemNum, secName, itemName, description, basePrice, numChoice) "
			+ "VALUES (:restId,:itemNum,:secName,:itemName,:description,:basePrice,:numChoice)";

	private static final String UPDATE_ITEM_RECORDS = "UPDATE Items SET secName=:secName,itemName=:itemName,description=:description,"
			+ "basePrice=:basePrice,numChoice=:numChoice WHERE resID =:restId and itemNum =:itemNum";

	private static final String GET_ITEMDETAILS_BY_ID = "SELECT * FROM Items where resID = :restId and itemNum = :itemNum";

	public void addItem(Item item) {

		try {
			Map<String, Object> paramMap = createParameterMap(item);

			namedParameterTemplate.update(INSERT_ITEM_RECORDS, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateItem(Item item) {

		try {
			Map<String, Object> paramMap = createParameterMap(item);

			namedParameterTemplate.update(UPDATE_ITEM_RECORDS, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Item> getItemListForRestaurant(String restId) {
		String SQL = "SELECT * FROM Items where resID = :restId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		List<Item> itemsOfRestaurant = (List<Item>) namedParameterTemplate.query(SQL, paramMap, new ItemMapper());

		for (Item item : itemsOfRestaurant) {
			List<Choice> choicesList = new ArrayList<Choice>();
			choicesList = choiceRepository.getChoiceListForItemOfRestaurant(restId, item.getItemNum());
			item.setChoices(choicesList);
		}

		return itemsOfRestaurant;
	}

	public Item getItemDetailsById(String restId, String itemNum) {
		Item item = new Item();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("itemNum", itemNum);
		item = namedParameterTemplate.queryForObject(GET_ITEMDETAILS_BY_ID, paramMap, new ItemMapper());
		List<Choice> choicesList = new ArrayList<Choice>();
		choicesList = choiceRepository.getChoiceListForItemOfRestaurant(restId, item.getItemNum());
		item.setChoices(choicesList);

		return item;

	}

	public void deleteItemFromRestaurant(String restId, String itemNo) {

		String SQL = "DELETE FROM Items where resID = :restId and itemNum =:itemNum";

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("restId", restId);
			paramMap.put("itemNum", itemNo);

			namedParameterTemplate.update(SQL, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
