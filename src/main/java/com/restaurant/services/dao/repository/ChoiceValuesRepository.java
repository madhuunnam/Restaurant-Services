package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.ChoiceValuesMapper;
import com.restaurant.services.model.Choice;
import com.restaurant.services.model.ChoiceValues;

@Component
public class ChoiceValuesRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;
	
	private static final String INSERT_CHOICEVALUES_RECORDS = "INSERT INTO ChValues(resID, chNum, valueName, valuePrice, extra) "
			+ "VALUES (:restId,:chNum,:valName,:valPrice,:extra)";

	private static final String UPDATE_CHOICEVALUES_RECORDS = "UPDATE ChValues SET valueName=:valName, valuePrice=:valPrice,extra=:extra WHERE "
			+ "resID =:restId and chNum =:chNum and valueId=:valId";

	public void addChoiceValues(ChoiceValues choiceVal) {

		Map<String, Object> paramMap = createParameterMap(choiceVal);

		namedParameterTemplate.update(INSERT_CHOICEVALUES_RECORDS, paramMap);
	}

	public void updateChoiceValues(ChoiceValues choiceVal) {

		Map<String, Object> paramMap = createParameterMap(choiceVal);

		namedParameterTemplate.update(UPDATE_CHOICEVALUES_RECORDS, paramMap);
	}
	
	public List<ChoiceValues> getChoiceValuesListForChoicesOfRestaurant(String restId, String chNum) {
		String SQL = "SELECT * FROM ChValues where resID = :restId and chNum = :chNum ";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("chNum", chNum);
		List<ChoiceValues> choiceValuesForChoicesOfRestaurant = (List<ChoiceValues>) namedParameterTemplate.query(SQL, paramMap,
				new ChoiceValuesMapper());
		return choiceValuesForChoicesOfRestaurant;
	}

	public void deleteChoiceValuesForChoicesOfRestaurant(String restId, String choiceNo, String valueId) {

		String SQL = "DELETE FROM ChValues where resID = :restId and chNum =:chNum and valueId =:valId";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("valId", valueId);
		paramMap.put("chNum", choiceNo);

		namedParameterTemplate.update(SQL, paramMap);

	}
	
	private Map<String, Object> createParameterMap(ChoiceValues choiceVal) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", choiceVal.getRestId());
		paramMap.put("chNum", choiceVal.getChNum());
		paramMap.put("valName", choiceVal.getValueName());
		paramMap.put("valId", choiceVal.getValueId());
		paramMap.put("valPrice", choiceVal.getValuePrice());
		paramMap.put("extra", choiceVal.isExtra());
		return paramMap;
	}
	

}
