package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.dao.mapper.LineItemMapper;
import com.restaurant.services.model.LineItem;

@Component
public class LineItemRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_LINEITEM_RECORDS = "INSERT INTO LineItems(resID, orderNum, lineNum, itemNum, "
			+ "itemName, choiceText, quantity, price, note) VALUES (:resID,:orderNum,:lineNum,:itemNum,:itemName,"
			+ ":choiceText,:quantity,:price,:note)";

	public void addLineItem(LineItem lineItem) {

		try {
			Map<String, Object> paramMap = createParameterMap(lineItem);

			namedParameterTemplate.update(INSERT_LINEITEM_RECORDS, paramMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<LineItem> getLineItemsForRestaurantOrder(String restId, String OrderNum) {
		String SQL = "SELECT * FROM LineItems where resID = :restId and orderNum =:orderNo";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", restId);
		paramMap.put("orderNo", OrderNum);
		List<LineItem> LineitemsOfRestaurantOrder = (List<LineItem>) namedParameterTemplate.query(SQL, paramMap,
				new LineItemMapper());

		return LineitemsOfRestaurantOrder;
	}

	private Map<String, Object> createParameterMap(LineItem item) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("resID", item.getRestId());
		paramMap.put("orderNum", item.getOrderNo());
		paramMap.put("lineNum", item.getLineNum());
		paramMap.put("itemNum", item.getItemNum());
		paramMap.put("itemName", item.getItemName());
		paramMap.put("choiceText", item.getChoiceText());
		paramMap.put("quantity", item.getQuantity());
		paramMap.put("price", item.getPrice());
		paramMap.put("note", item.getNote());
		return paramMap;
	}

}
