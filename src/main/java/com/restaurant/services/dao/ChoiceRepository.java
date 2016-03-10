package com.restaurant.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Choice;
import com.restaurant.services.model.Item;

@Component
public class ChoiceRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_CHOICE_RECORDS = "INSERT INTO Choices(resID, itemNum, chNum, chTitle, chType, required, numValue) "
			+ "VALUES (:restId,:itemNum,:chNum,:chTitle,:chType,:required,:numValue)";

	private static final String UPDATE_CHOICE_RECORDS = "UPDATE Choices SET chTitle=:chTitle,chType=:chType,required=:required,"
			+ "numValue=:numValue WHERE resID = :restId and chNum =:chNum and itemNum=:itemNum";

	public void addChoice(Choice choice) {

		Map<String, Object> paramMap = createParameterMap(choice);

		namedParameterTemplate.update(INSERT_CHOICE_RECORDS, paramMap);
	}

	public void updateChoice(Choice choice) {

		Map<String, Object> paramMap = createParameterMap(choice);

		namedParameterTemplate.update(UPDATE_CHOICE_RECORDS, paramMap);
	}

	public List<Choice> getChoiceListForItemOfRestaurant(String restId, String itemNum) {
		String SQL = "SELECT * FROM Choices where resID = :restId and itemNum = :itemNum";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("itemNum", itemNum);
		List<Choice> choicesForItemsOfRestaurant = (List<Choice>) namedParameterTemplate.query(SQL, paramMap,
				new ChoiceMapper());
		return choicesForItemsOfRestaurant;
	}

	public void deleteChoiceForItemOfRestaurant(String restId, String itemNo, String choiceNo) {

		String SQL = "DELETE FROM Choices where resID = :restId and itemNum =:itemNum and chNum =:chNum";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("itemNum", itemNo);
		paramMap.put("chNum", choiceNo);

		namedParameterTemplate.update(SQL, paramMap);

	}

	private Map<String, Object> createParameterMap(Choice choice) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", choice.getRestId());
		paramMap.put("itemNum", choice.getItemNum());
		paramMap.put("chNum", choice.getChNum());
		paramMap.put("chTitle", choice.getChTitle());
		paramMap.put("chType", choice.getChType());
		paramMap.put("required", choice.isRequired());
		paramMap.put("numValue", choice.getNumValue());
		return paramMap;
	}
}
