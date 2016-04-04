package com.restaurant.services.dao.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.restaurant.services.model.Transaction;

@Component
public class TransactionRepository {

	@Autowired
	NamedParameterJdbcTemplate namedParameterTemplate;

	private static final String INSERT_TRANSACTION_RECORDS = "INSERT INTO Transactions(resID, orderNum, custId, custName, resName, orderType, orderTime, numberOfLines, "
			+ "itemName, subTot, discountPercentage, taxRatePercent, taxAmount, tip, deliFee, totPrice, receiverName, deliAddr, status, msgToCust, msgToRes, "
			+ "nonSmoke, resTable, resPeople, resTime, pickTime, arriveTime, agentName, notes) VALUES (:restId,:orderNo,:custId,:custName,:restName,"
			+ ":orderType,:orderTime,:numberOfLines,:itemName,:subTot,:discountPercentage,:taxRatePercent,:taxAmount,:tip,:deliFee,:totPrice,:receiverName,:deliAddr,"
			+ ":status,:msgToCust,:msgToRes,:nonSmoke,:resTable,:resPeople,:resTime,:pickTime,:arriveTime,:agentName,:notes)";

	public void addTransaction(Transaction order) {

		Map<String, Object> paramMap = createParameterMap(order);

		namedParameterTemplate.update(INSERT_TRANSACTION_RECORDS, paramMap);

	}

	private Map<String, Object> createParameterMap(Transaction order) {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("restId", order.getRestId());
		paramMap.put("orderNo", order.getOrderNo());
		paramMap.put("custId", order.getCustId());
		paramMap.put("custName", order.getCustName());
		paramMap.put("restName", order.getResName());
		paramMap.put("orderType", order.getOrderType());
		paramMap.put("orderTime", order.getOrderTime());
		paramMap.put("numberOfLines", order.getNumberOfLines());
		paramMap.put("itemName", order.getItemName());
		paramMap.put("subTot", order.getSubTot());
		paramMap.put("discountPercentage", order.getDiscountPercentage());
		paramMap.put("taxRatePercent", order.getTaxRatePercent());
		paramMap.put("taxAmount", order.getTaxAmount());
		paramMap.put("tip", order.getTip());
		paramMap.put("deliFee", order.getDeliFee());
		paramMap.put("totPrice", order.getTotPrice());
		paramMap.put("receiverName", order.getReceiverName());
		paramMap.put("deliAddr", order.getDeliAddr());
		paramMap.put("status", order.getStatus());
		paramMap.put("msgToCust", order.getMsgToCust());
		paramMap.put("msgToRes", order.getMsgToRes());
		paramMap.put("nonSmoke", order.getNonSmoke());
		paramMap.put("resTable", order.getResTable());
		paramMap.put("resPeople", order.getResPeople());
		paramMap.put("resTime", order.getResTime());
		paramMap.put("pickTime", order.getPickTime());
		paramMap.put("arriveTime", order.getArriveTime());
		paramMap.put("agentName", order.getAgentName());
		paramMap.put("notes", order.getNotes());

		return paramMap;
	}
}
