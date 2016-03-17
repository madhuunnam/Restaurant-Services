package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.SectionMapper;
import com.restaurant.services.model.ChoiceValues;
import com.restaurant.services.model.Section;

@Component
public class SectionRepository {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_SECTION_RECORDS = "INSERT INTO Sections(resID, secName, numItem) "
			+ "VALUES (:restId,:secName,:numItem)";

	private static final String UPDATE_SECTION_RECORDS = "UPDATE Sections SET numItem=:numItem WHERE resID =:resID and secName = :secName";

	public void addSection(Section sec) {

		Map<String, Object> paramMap = createParameterMap(sec);

		namedParameterTemplate.update(INSERT_SECTION_RECORDS, paramMap);
	}

	public void updateSection(Section sec) {

		Map<String, Object> paramMap = createParameterMap(sec);

		namedParameterTemplate.update(UPDATE_SECTION_RECORDS, paramMap);
	}
	
	public List<Section> getSectionListForRestaurant(String restId) {
		String SQL = "SELECT * FROM Sections where resID = :restId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		List<Section> sectionsOfRestaurant = (List<Section>) namedParameterTemplate.query(SQL, paramMap,
				new SectionMapper());
		return sectionsOfRestaurant;
	}

	public void deleteSectionForRestaurant(String restId) {

		String SQL = "DELETE FROM Sections where resID = :restId";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);

		namedParameterTemplate.update(SQL, paramMap);

	}
	
	private Map<String, Object> createParameterMap(Section sec) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", sec.getRestId());
		paramMap.put("secName", sec.getSecName());
		paramMap.put("numItem", sec.getNumItem());
		return paramMap;
	}
	
}
